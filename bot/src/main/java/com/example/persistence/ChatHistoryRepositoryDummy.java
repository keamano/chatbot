package com.example.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.Chat;

@Repository
public class ChatHistoryRepositoryDummy implements ChatHistoryRepository {

	private List<Chat> chatList = new ArrayList<Chat>();
	
	ChatHistoryRepositoryDummy() {
		chatList.add(new Chat(1, "誰ですか", "ボットです"));
		chatList.add(new Chat(2, "天気", "快晴です"));
		chatList.add(new Chat(3, "こんにちは", "こんにちは"));
	}
	
	@Override
	public List<Chat> findAll() {
		return chatList;
	}

	@Override
	public int insert(Chat chat) {
		int nextId;
		if (chatList.isEmpty()) {
			nextId = 1;
		} else {
			int size = chatList.size();
			Chat lastChat = chatList.get(size -1);
			int lastId = lastChat.getId();
			nextId = lastId + 1;
		}
		
		chat.setId(nextId);
		chatList.add(chat);
		
		return nextId;
	}

}
