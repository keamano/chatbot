package com.example.form;

import com.example.entity.BotQa;

public class BotForm {

    private Integer id;

    private String question;

    private String answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public BotQa convertToEntity() {
        return new BotQa(id, question, answer);
    }

}
