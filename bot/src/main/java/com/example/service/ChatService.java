package com.example.service;

import java.util.List;

import com.example.entity.ChatQa;

public interface ChatService {

    List<ChatQa> findAll();

    void ask(String question);
}