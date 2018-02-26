package com.example.persistence;

import java.util.List;

import com.example.entity.Question;

public interface QuestionRepository {

    List<Question> findAll();
    
	Question findById(Integer id);
	
    Question findByQuestion(String question);

    int insert(Question question);
    
    int update(Question question);
    
    int delete(Question question);
    
}
