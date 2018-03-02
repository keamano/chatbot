package com.example.persistence;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.ChatQa;

@Repository
public class ChatQaRepositoryPostgres implements ChatQaRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ChatQaRepositoryPostgres(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ChatQa> findAll() {
        String sql = "SELECT id, question, answer" + " FROM chat_qa" + " ORDER BY id";
        List<ChatQa> chatQaList = jdbcTemplate.query(sql,
                (rs, rowNum) -> new ChatQa(rs.getInt("id"), rs.getString("question"), rs.getString("answer")));
        return chatQaList;
    }

    @Override
    public int insert(ChatQa chatQa) {
        String sql = "INSERT INTO chat_qa(question, answer)" + " VALUES(:question, :answer)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("question", chatQa.getQuestion());
        parameterSource.addValue("answer", chatQa.getAnswer());
        int rows = jdbcTemplate.update(sql, parameterSource);
        return rows;
    }

}
