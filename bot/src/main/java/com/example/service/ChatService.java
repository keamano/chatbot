package com.example.service;

import java.util.List;

import com.example.entity.Chat;

public interface ChatService {

    List<Chat> findAllHistory();

    void insert(Chat chat);
    
    Chat findByQuestion(String question);
}