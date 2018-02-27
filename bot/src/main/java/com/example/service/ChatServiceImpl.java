package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.ChatHistory;
import com.example.entity.QuestionAndAnswer;
import com.example.persistence.ChatHistoryRepository;
import com.example.persistence.QuestionAndAnswerRepository;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatHistoryRepository chatHistoryRepository;

    private final QuestionAndAnswerRepository questionAndAnswerRepository;

    public ChatServiceImpl(ChatHistoryRepository chatHistoryRepository, QuestionAndAnswerRepository questionAndAnswerRepository) {
        this.chatHistoryRepository = chatHistoryRepository;
        this.questionAndAnswerRepository = questionAndAnswerRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ChatHistory> findAllHistory() {
        return chatHistoryRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void ask(String question) {
        QuestionAndAnswer questionAndAnswer = questionAndAnswerRepository.findByQuestion(question);

        String answer = "わかりません。";
        if (questionAndAnswer != null) {
            answer = questionAndAnswer.getAnswer();
        }

        ChatHistory chatHistory = new ChatHistory(question, answer);
        chatHistoryRepository.insert(chatHistory);
    }
}
