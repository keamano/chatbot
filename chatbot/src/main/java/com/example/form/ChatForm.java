package com.example.form;


import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.example.entity.ChatQa;
import com.example.validation.Group1;
import com.example.validation.Group2;

public class ChatForm {
	
    @NotBlank(groups = Group1.class)
    @Length(min = 1, max =20, groups = Group2.class)
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
