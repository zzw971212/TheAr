package com.zzw.thinkpad.thear.ui.activity.Test.Module;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thinkpad on 2018/9/28.
 */

public class Test1Get {
    @SerializedName("id")
    private int id;
    @SerializedName("question")
    private String question;
    @SerializedName("subject")
    private String subject;
    @SerializedName("answer")
    private String answer;

    public Test1Get(int id, String question, String subject, String answer) {
        this.id = id;
        this.question = question;
        this.subject = subject;
        this.answer = answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getSubject() {
        return subject;
    }

    public String getAnswer() {
        return answer;
    }
}
