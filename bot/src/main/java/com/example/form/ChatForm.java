package com.example.form;


import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.example.entity.ChatQa;

public class ChatForm {

    @NotBlank
    @Length(min = 1, max =20)
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
