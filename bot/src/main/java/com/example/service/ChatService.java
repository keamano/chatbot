package com.example.service;

import java.util.List;

import com.example.entity.Chat;

public interface ChatService {

    List<Chat> findAll();

    void insert(Chat chat);
    
}
