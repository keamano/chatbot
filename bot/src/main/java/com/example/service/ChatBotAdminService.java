package com.example.service;

import java.util.List;

import com.example.entity.QuestionAndAnswer;

public interface ChatBotAdminService {

    List<QuestionAndAnswer> findAll();

    QuestionAndAnswer findById(Integer id);

    void insert(QuestionAndAnswer questionAndAnswer);

    void update(QuestionAndAnswer questionAndAnswer);

    void delete(QuestionAndAnswer questionAndAnswer);
}
