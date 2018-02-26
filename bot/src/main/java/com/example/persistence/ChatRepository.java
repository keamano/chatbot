package com.example.persistence;

import java.util.List;

import com.example.entity.Chat;

public interface ChatRepository {
	
    List<Chat> findAll();

    int insert(Chat chat);
    
}
