package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Chat;
import com.example.persistence.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService {
	
	private final ChatRepository chatRepository;

	public ChatServiceImpl(ChatRepository chatRepository) {
		this.chatRepository = chatRepository;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Chat> findAll() {
		return chatRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Chat chat) {
		chatRepository.insert(chat);
	}

}
