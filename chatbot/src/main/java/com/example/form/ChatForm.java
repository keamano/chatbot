package com.example.form;


import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.example.entity.ChatQa;
import com.example.validation.Group1;
import com.example.validation.Group2;

public class ChatForm {
	
	// TODO �K�{���̓`�F�b�N�p�̃A�m�e�[�V������ǉ����܂��傤
	// TODO ������̒����`�F�b�N�p�̃A�m�e�[�V������ǉ����܂��傤
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
