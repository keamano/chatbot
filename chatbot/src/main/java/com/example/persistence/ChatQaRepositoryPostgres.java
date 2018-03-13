package com.example.persistence;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.ChatQa;

// TODO : コンポーネントスキャンの対象にするためのアノテーションを記載
public class ChatQaRepositoryPostgres implements ChatQaRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ChatQaRepositoryPostgres(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ChatQa> findAll() {
    		// TODO : SELECT文を実装する
        return null;
    }

    @Override
    public int insert(ChatQa chatQa) {
    		// TODO : INSERT文を実装する
        return 0;
    }

}
