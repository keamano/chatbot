package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Bot;
import com.example.persistence.BotRepository;

@Service
public class BotServiceImpl implements BotService {
	
	private final BotRepository botRepository;
	
	public BotServiceImpl(BotRepository botRepository) {
		this.botRepository = botRepository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Bot> findAll() {
		return botRepository.findAll();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Bot findById(Integer id) {
		return botRepository.findById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Bot findByQuestion(String question) {
		Bot bot = botRepository.findByQuestion(question);
		
		if (bot == null) {
			bot = new Bot(question, "よくわかりません。");
		}
		
		return bot;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Bot bot) {
		botRepository.insert(bot);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Bot bot) {
		botRepository.update(bot);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Bot bot) {
		botRepository.delete(bot);
	}

}