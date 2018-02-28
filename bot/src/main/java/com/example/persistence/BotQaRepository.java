package com.example.persistence;

import java.util.List;

import com.example.entity.BotQa;

public interface BotQaRepository {

    List<BotQa> findAll();

    BotQa findById(Integer id);

    BotQa findByQuestion(String question);

    int insert(BotQa botQa);

    int update(BotQa botQa);

    int delete(BotQa botQa);

}
