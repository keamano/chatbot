package com.example.persistence;

import java.util.List;

import com.example.entity.ChatQa;

public interface ChatQaRepository {

    List<ChatQa> findAll();

    int insert(ChatQa chatQa);

}
