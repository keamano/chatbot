package com.example.web;

import com.example.entity.Question;

public class QuestionForm {
	
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
	
    public Question convertToEntity() {
        return new Question(id, question, answer);
    }

}
