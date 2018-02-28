package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.BotQa;
import com.example.persistence.BotQaRepository;

@Service
public class BotServiceImpl implements BotService {

    private final BotQaRepository botQaRepostiroy;

    public BotServiceImpl(BotQaRepository botQaRepostiroy) {
        this.botQaRepostiroy = botQaRepostiroy;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<BotQa> findAll() {
        return botQaRepostiroy.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public BotQa findById(Integer id) {
        return botQaRepostiroy.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void insert(BotQa questionAndAnswer) {
        botQaRepostiroy.insert(questionAndAnswer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(BotQa questionAndAnswer) {
        botQaRepostiroy.update(questionAndAnswer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(BotQa questionAndAnswer) {
        botQaRepostiroy.delete(questionAndAnswer);
    }

}
