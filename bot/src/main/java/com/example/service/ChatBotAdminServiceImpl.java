package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.QuestionAndAnswer;
import com.example.persistence.QuestionAndAnswerRepository;

@Service
public class ChatBotAdminServiceImpl implements ChatBotAdminService {

    private final QuestionAndAnswerRepository questionAndAnswerRepository;

    public ChatBotAdminServiceImpl(QuestionAndAnswerRepository questionAndAnswerRepository) {
        this.questionAndAnswerRepository = questionAndAnswerRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<QuestionAndAnswer> findAll() {
        return questionAndAnswerRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public QuestionAndAnswer findById(Integer id) {
        return questionAndAnswerRepository.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void insert(QuestionAndAnswer questionAndAnswer) {
        questionAndAnswerRepository.insert(questionAndAnswer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(QuestionAndAnswer questionAndAnswer) {
        questionAndAnswerRepository.update(questionAndAnswer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(QuestionAndAnswer questionAndAnswer) {
        questionAndAnswerRepository.delete(questionAndAnswer);
    }

}
