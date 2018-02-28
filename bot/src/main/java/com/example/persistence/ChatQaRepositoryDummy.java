package com.example.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.ChatQa;

@Repository
public class ChatQaRepositoryDummy implements ChatQaRepository {

    private List<ChatQa> chatQaList = new ArrayList<ChatQa>();

    ChatQaRepositoryDummy() {
        chatQaList.add(new ChatQa(1, "誰ですか", "ボットです"));
        chatQaList.add(new ChatQa(2, "天気", "快晴です"));
        chatQaList.add(new ChatQa(3, "こんにちは", "こんにちは"));
    }

    @Override
    public List<ChatQa> findAll() {
        return chatQaList;
    }

    @Override
    public int insert(ChatQa chatQa) {
        int nextId;
        if (chatQaList.isEmpty()) {
            nextId = 1;
        } else {
            int size = chatQaList.size();
            ChatQa lastChat = chatQaList.get(size - 1);
            int lastId = lastChat.getId();
            nextId = lastId + 1;
        }

        chatQa.setId(nextId);
        chatQaList.add(chatQa);

        return nextId;
    }

}
