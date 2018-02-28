package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.BotQa;
import com.example.entity.ChatQa;
import com.example.persistence.BotQaRepository;
import com.example.persistence.ChatQaRepository;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatQaRepository chatQaRepository;

    private final BotQaRepository botQaRepository;

    public ChatServiceImpl(ChatQaRepository chatQaRepository, BotQaRepository botQaRepository) {
        this.chatQaRepository = chatQaRepository;
        this.botQaRepository = botQaRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ChatQa> findAll() {
        return chatQaRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void ask(String question) {
        BotQa botQa = botQaRepository.findByQuestion(question);

        String answer = "わかりません。";
        if (botQa != null) {
            answer = botQa.getAnswer();
        }
        ChatQa chatQa = new ChatQa(question, answer);

        chatQaRepository.insert(chatQa);
    }
}
