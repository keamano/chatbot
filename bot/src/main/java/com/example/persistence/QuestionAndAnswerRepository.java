package com.example.persistence;

import java.util.List;

import com.example.entity.QuestionAndAnswer;

public interface QuestionAndAnswerRepository {

    List<QuestionAndAnswer> findAll();

    QuestionAndAnswer findById(Integer id);

    QuestionAndAnswer findByQuestion(String question);

    int insert(QuestionAndAnswer questionAndAnswer);

    int update(QuestionAndAnswer questionAndAnswer);

    int delete(QuestionAndAnswer questionAndAnswer);

}
