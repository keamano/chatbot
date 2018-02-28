package com.example.form;

import com.example.entity.ChatQa;

public class ChatForm {

    private String question;

    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ChatQa convertToEntity() {
        return new ChatQa(question, "");
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
