package com.example.persistence;

import java.util.List;

import com.example.entity.Chat;

public interface ChatHistoryRepository {
	
    List<Chat> findAll();

    int insert(Chat chat);
    
}
