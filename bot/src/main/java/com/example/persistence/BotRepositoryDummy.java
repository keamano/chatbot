package com.example.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.Bot;

@Repository
public class BotRepositoryDummy implements BotRepository {
	
	private List<Bot> botList = new ArrayList<Bot>();
	
	BotRepositoryDummy() {
		botList.add(new Bot(1, "誰ですか", "ボットです"));
		botList.add(new Bot(2, "天気", "快晴です"));
		botList.add(new Bot(3, "こんにちは", "こんにちは"));
	}

	@Override
	public List<Bot> findAll() {
		return botList;
	}
	
	@Override
	public Bot findById(Integer id) {
		for (Bot bot : botList) {
			if (id == bot.getId()) {
				return bot;
			}
		}
		return null;
	}

	@Override
	public Bot findByQuestion(String question) {
		for (Bot bot : botList) {
			if (question.indexOf(bot.getQuestion()) >= 0) {
				return bot;
			}
		}
		return null;
	}

	@Override
	public int insert(Bot bot) {
		int nextId;
		if (botList.isEmpty()) {
			nextId = 1;
		} else {
			int size = botList.size();
			Bot lastBot = botList.get(size -1);
			int lastId = lastBot.getId();
			nextId = lastId + 1;
		}
		
		bot.setId(nextId);
		botList.add(bot);
		
		return nextId;
	}

	@Override
	public int update(Bot bot) {
		Bot targetBot = findById(bot.getId());
		if (targetBot == null) {
			return -1;
		}
		
		targetBot.setQuestion(bot.getQuestion());
		targetBot.setAnswer(bot.getAnswer());
		
		return bot.getId();
	}

	@Override
	public int delete(Bot bot) {
		Bot targetBot = findById(bot.getId());
		if (targetBot == null) {
			return -1;
		}

		botList.remove(targetBot);
		
		return bot.getId();
	}

}