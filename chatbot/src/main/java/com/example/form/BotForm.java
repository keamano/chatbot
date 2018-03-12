package com.example.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.example.entity.BotQa;
import com.example.validation.Group1;
import com.example.validation.Group2;

public class BotForm {

    private Integer id;

    @NotBlank(groups = Group1.class) // (1)@NotBkank
    @Length(min = 1, max =20, groups = Group2.class) // (2)Length
    private String question;

    @NotBlank(groups = Group1.class)
    @Length(min = 1, max =20, groups = Group2.class)
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
