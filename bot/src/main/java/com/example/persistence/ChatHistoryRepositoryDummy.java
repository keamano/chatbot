package com.example.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.ChatHistory;

@Repository
public class ChatHistoryRepositoryDummy implements ChatHistoryRepository {

    private List<ChatHistory> chatHistoryList = new ArrayList<ChatHistory>();

    ChatHistoryRepositoryDummy() {
        chatHistoryList.add(new ChatHistory(1, "誰ですか", "ボットです"));
        chatHistoryList.add(new ChatHistory(2, "天気", "快晴です"));
        chatHistoryList.add(new ChatHistory(3, "こんにちは", "こんにちは"));
    }

    @Override
    public List<ChatHistory> findAll() {
        return chatHistoryList;
    }

    @Override
    public int insert(ChatHistory chatHistory) {
        int nextId;
        if (chatHistoryList.isEmpty()) {
            nextId = 1;
        } else {
            int size = chatHistoryList.size();
            ChatHistory lastChat = chatHistoryList.get(size - 1);
            int lastId = lastChat.getId();
            nextId = lastId + 1;
        }

        chatHistory.setId(nextId);
        chatHistoryList.add(chatHistory);

        return nextId;
    }

}
