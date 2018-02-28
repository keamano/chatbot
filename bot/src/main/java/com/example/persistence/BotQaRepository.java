package com.example.persistence;

import java.util.List;

import com.example.entity.BotQa;

public interface BotQaRepository {

    List<BotQa> findAll();

    BotQa findById(Integer id);

    BotQa findByQuestion(String question);

    int insert(BotQa questionAndAnswer);

    int update(BotQa questionAndAnswer);

    int delete(BotQa questionAndAnswer);

}
