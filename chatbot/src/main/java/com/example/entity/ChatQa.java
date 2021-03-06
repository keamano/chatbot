package com.example.entity;

public class ChatQa {
    private Integer id;
    private String question;
    private String answer;

    public ChatQa() {
    }

    public ChatQa(String question, String answer) {
        this.setQuestion(question);
        this.setAnswer(answer);
    }

    public ChatQa(Integer id, String question, String answer) {
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
