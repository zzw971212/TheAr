package com.zzw.thinkpad.thear.weight;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zzw on 2018/5/22.
 */

/**
 * Toast工具
 * */
public class ToastUtil {
    public static void showShortToast(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
