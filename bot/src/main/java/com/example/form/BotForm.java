package com.example.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.example.entity.BotQa;

public class BotForm {

    private Integer id;

    @NotBlank
    @Length(min = 1, max =20)
    private String question;

    @NotBlank
    @Length(min = 1, max =20)
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
