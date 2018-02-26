package com.example.entity;

public class Bot {
	private Integer id;
	private String question;
	private String answer;

	public Bot() {
	}

	public Bot(String question, String answer) {
		this.setQuestion(question);
		this.setAnswer(answer);
	}

	public Bot(Integer id, String question, String answer) {
		this.id = id;
		this.setQuestion(question);
		this.setAnswer(answer);
	}

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
}
