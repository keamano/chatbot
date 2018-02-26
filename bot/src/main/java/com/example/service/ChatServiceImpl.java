package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Question;
import com.example.entity.Chat;
import com.example.persistence.QuestionRepository;
import com.example.persistence.ChatHistoryRepository;

@Service
public class ChatServiceImpl implements ChatService {
	
	private final ChatHistoryRepository chatHistoryRepository;
	
	private final QuestionRepository botRepository;

	public ChatServiceImpl(ChatHistoryRepository chatHistoryRepository, QuestionRepository botRepository) {
		this.chatHistoryRepository = chatHistoryRepository;
		this.botRepository = botRepository;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Chat> findAllHistory() {
		return chatHistoryRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Chat chat) {
		chatHistoryRepository.insert(chat);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Chat findByQuestion(String question) {
		Question bot = botRepository.findByQuestion(question);
		
		String answer = "わかりません。";
		if (bot != null) {
			answer = bot.getAnswer();
		}
		
		return new Chat(question, answer);
	}
}
