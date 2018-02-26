package com.example.service;

import java.util.List;

import com.example.entity.Bot;

public interface BotService {

    List<Bot> findAll();
    
    Bot findById(Integer id);
    
    Bot findByQuestion(String question);

    void insert(Bot bot);
    
    void update(Bot bot);
    
    void delete(Bot bot);
}