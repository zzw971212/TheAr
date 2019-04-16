//================================================================================================================================
//
//  Copyright (c) 2015-2017 VisionStar Information Technology (Shanghai) Co., Ltd. All Rights
// Reserved.
//  EasyAR is the registered trademark or trademark of VisionStar Information Technology
// (Shanghai) Co., Ltd in China
//  and other countries for the augmented reality technology developed by VisionStar Information
// Technology (Shanghai) Co., Ltd.
//
//================================================================================================================================

package com.zzw.thinkpad.thear.easyAR;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;

import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

import cn.easyar.Engine;

public class GLView extends GLSurfaceView {
    private HelloAR mHelloAR;
    private boolean isTakePicture = false;
    private int mOutputWidth;
    private int mOutputHeight;

    public void cancelListener() {
        mHelloAR.cancelListener();
    }

    public interface EventListener {
        void successEvent(String targetName);

        void failEvent();
    }

    public void resumeListener() {
        mHelloAR.resumeListener();
    }

    EventListener mEventListener;

    public void setEventListener(EventListener eventListener) {
        mEventListener = eventListener;
    }

    private Context mContext;
    GL10 gl10;

    public GLView(Context context) {
        super(context);
        mContext = context;
        setEGLContextFactory(new ContextFactory());
        setEGLConfigChooser(new ConfigChooser());
        mHelloAR = new HelloAR();

        mHelloAR.setTrackedListener(new HelloAR.TrackedListener() {
            @Override
            public void trackedSuccess(String targetName) {
                if (mEventListener != null) {
                    mEventListener.successEvent(targetName);
                }
            }

            @Override
            public void trackedFailed() {
                if (mEventListener != null) {
                    mEventListener.failEvent();
                }
            }
        });
        this.setRenderer(new Renderer() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                synchronized (mHelloAR) {
                    mHelloAR.initGL();
                }
            }

            @Override
            public void onSurfaceChanged(GL10 gl, int w, int h) {
                synchronized (mHelloAR) {
                    mHelloAR.resizeGL(w, h);
                }
            }

            @Override
            public void onDrawFrame(GL10 gl) {
                GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

                synchronized (mHelloAR) {
                    mHelloAR.render();
                }
                gl10 = gl;

                // 获取GLSurfaceView的图片并保存
                if (mScreenShootListener != null) {
//                    Bitmap bmp = createBitmapFromGLSurface(0, 0, mOutputWidth,
//                            mOutputHeight, gl);
                    Bitmap bmp = getBitmapFromGL(mOutputWidth, mOutputHeight, gl);
                    mScreenShootListener.shootCallback(bmp);
                    mScreenShootListener = null;
                    //                    isTakePicture=false;
                }
            }
        });
        this.setZOrderMediaOverlay(true);
    }


    public interface ScreenShootListener {
        void shootCallback(Bitmap glBitmap);
    }

    private ScreenShootListener mScreenShootListener;


    private Bitmap createBitmapFromGLSurface(int x, int y, int w, int h, GL10 gl) {
        int bitmapBuffer[] = new int[w * h];
        int bitmapSource[] = new int[w * h];
        IntBuffer intBuffer = IntBuffer.wrap(bitmapBuffer);
        intBuffer.position(0);
        try {
            gl.glReadPixels(x, y, w, h, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE,
                    intBuffer);
            int offset1, offset2;
            for (int i = 0; i < h; i++) {
                offset1 = i * w;
                offset2 = (h - i - 1) * w;
                for (int j = 0; j < w; j++) {
                    int texturePixel = bitmapBuffer[offset1 + j];
                    int blue = (texturePixel >> 16) & 0xff;
                    int red = (texturePixel << 16) & 0x00ff0000;
                    int pixel = (texturePixel & 0xff00ff00) | red | blue;
                    bitmapSource[offset2 + j] = pixel;
                }
            }
        } catch (GLException e) {
            return null;
        }
        return Bitmap.createBitmap(bitmapSource, w, h, Bitmap.Config.ARGB_8888);
    }

    /**
     * 将GL10帧数据保存为图片
     *
     * @param w
     * @param h
     * @param gl
     * @return
     */
    private Bitmap getBitmapFromGL(int w, int h, GL10 gl) {
        int b[] = new int[w * (h)];
        int bt[] = new int[w * h];
        IntBuffer ib = IntBuffer.wrap(b);
        ib.position(0);
        gl.glReadPixels(0, 0, w, h, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, ib);
        for (int i = 0, k = 0; i < h; i++, k++) {
            for (int j = 0; j < w; j++) {
                int pix = b[i * w + j];
                int pb = (pix >> 16) & 0xff;
                int pr = (pix << 16) & 0xffff0000;
                int pix1 = (pix & 0xff00ff00) | pr | pb;
                bt[(h - k - 1) * w + j] = pix1;
            }
        }
        return Bitmap.createBitmap(bt, w, h, Bitmap.Config.ARGB_8888);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        synchronized (mHelloAR) {
            if (mHelloAR.initialize()) {
                mHelloAR.start();
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        synchronized (mHelloAR) {
            mHelloAR.stop();
            mHelloAR.dispose();
        }
        super.onDetachedFromWindow();
    }

    @Override
    public void onResume() {
        super.onResume();
        mHelloAR.resumeListener();
        Engine.onResume();
    }

    @Override
    public void onPause() {

        Engine.onPause();
        super.onPause();
    }

    private static class ContextFactory implements EGLContextFactory {
        private static int EGL_CONTEXT_CLIENT_VERSION = 0x3098;

        public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig eglConfig) {
            EGLContext context;
            int[] attrib = {EGL_CONTEXT_CLIENT_VERSION, 2, EGL10.EGL_NONE};
            context = egl.eglCreateContext(display, eglConfig, EGL10.EGL_NO_CONTEXT, attrib);
            return context;
        }

        public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context) {
            egl.eglDestroyContext(display, context);
        }
    }

    private static class ConfigChooser implements EGLConfigChooser {
        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            final int EGL_OPENGL_ES2_BIT = 0x0004;
            final int[] attrib = {EGL10.EGL_RED_SIZE, 4, EGL10.EGL_GREEN_SIZE, 4,
                    EGL10.EGL_BLUE_SIZE, 4,
                    EGL10.EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT, EGL10.EGL_NONE};

            int[] num_config = new int[1];
            egl.eglChooseConfig(display, attrib, null, 0, num_config);

            int numConfigs = num_config[0];
            if (numConfigs <= 0)
                throw new IllegalArgumentException("fail to choose EGL configs");

            EGLConfig[] configs = new EGLConfig[numConfigs];
            egl.eglChooseConfig(display, attrib, configs, numConfigs,
                    num_config);

            for (EGLConfig config : configs) {
                int[] val = new int[1];
                int r = 0, g = 0, b = 0, a = 0, d = 0;
                if (egl.eglGetConfigAttrib(display, config, EGL10.EGL_DEPTH_SIZE, val))
                    d = val[0];
                if (d < 16)
                    continue;

                if (egl.eglGetConfigAttrib(display, config, EGL10.EGL_RED_SIZE, val))
                    r = val[0];
                if (egl.eglGetConfigAttrib(display, config, EGL10.EGL_GREEN_SIZE, val))
                    g = val[0];
                if (egl.eglGetConfigAttrib(display, config, EGL10.EGL_BLUE_SIZE, val))
                    b = val[0];
                if (egl.eglGetConfigAttrib(display, config, EGL10.EGL_ALPHA_SIZE, val))
                    a = val[0];
                if (r == 8 && g == 8 && b == 8 && a == 0)
                    return config;
            }

            return configs[0];
        }
    }
}
