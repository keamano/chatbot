package com.example.web;

import com.example.entity.Chat;

public class ChatForm {
	
    private String question;
    
    private String answer;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
    public Chat convertToEntity() {
        return new Chat(question, "");
    }

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
    
}