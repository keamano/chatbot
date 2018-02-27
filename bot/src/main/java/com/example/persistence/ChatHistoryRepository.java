package com.example.persistence;

import java.util.List;

import com.example.entity.ChatHistory;

public interface ChatHistoryRepository {

    List<ChatHistory> findAll();

    int insert(ChatHistory chat);

}
