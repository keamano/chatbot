package com.example.service;

import java.util.List;

import com.example.entity.BotQa;

public interface BotService {

    List<BotQa> findAll();

    BotQa findById(Integer id);

    void insert(BotQa questionAndAnswer);

    void update(BotQa questionAndAnswer);

    void delete(BotQa questionAndAnswer);
}
