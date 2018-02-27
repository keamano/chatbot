package com.example.service;

import java.util.List;

import com.example.entity.ChatHistory;

public interface ChatService {

    List<ChatHistory> findAllHistory();

    void ask(String question);
}