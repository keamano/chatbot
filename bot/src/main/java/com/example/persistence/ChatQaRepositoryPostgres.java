package com.example.persistence;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.entity.ChatQa;

//@Repository
public class ChatQaRepositoryPostgres implements ChatQaRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ChatQaRepositoryPostgres(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ChatQa> findAll() {
        String sql = "SELECT id, question, answer" + " FROM chat" + " ORDER BY id";
        List<ChatQa> chatList = jdbcTemplate.query(sql,
                (rs, rowNum) -> new ChatQa(rs.getInt("id"), rs.getString("question"), rs.getString("answer")));
        return chatList;
    }

    @Override
    public int insert(ChatQa chat) {
        String sql = "INSERT INTO chat(question, answer)" + " VALUES(:question, :answer)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("question", chat.getQuestion());
        parameterSource.addValue("answer", chat.getAnswer());
        int rows = jdbcTemplate.update(sql, parameterSource);
        return rows;
    }

}
