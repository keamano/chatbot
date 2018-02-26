package com.example.persistence;

import java.util.List;

import com.example.entity.Bot;

public interface BotRepository {

    List<Bot> findAll();
    
	Bot findById(Integer id);
	
    Bot findByQuestion(String question);

    int insert(Bot bot);
    
    int update(Bot bot);
    
    int delete(Bot bot);
    
}
