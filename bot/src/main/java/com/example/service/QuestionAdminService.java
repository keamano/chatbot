package com.example.service;

import java.util.List;

import com.example.entity.Question;

public interface QuestionAdminService {

    List<Question> findAll();
    
    Question findById(Integer id);
    
    void insert(Question question);
    
    void update(Question question);
    
    void delete(Question question);
}
