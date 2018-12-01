package com.dvuthanhlong.quizapp;

public class Question {
    private String content;
    private boolean isTrue;

    public Question(String content, boolean isTrue) {
        this.content = content;
        this.isTrue = isTrue;
    }

    public String getContent() {
        return content;
    }

    public boolean getAnswer() {
        return isTrue;
    }
}
