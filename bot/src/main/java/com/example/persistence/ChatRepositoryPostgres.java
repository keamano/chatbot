package com.example.persistence;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.Chat;

@Repository
public class ChatRepositoryPostgres implements ChatRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
    public ChatRepositoryPostgres(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public List<Chat> findAll() {
        String sql = "SELECT id, question, answer" +
                " FROM chat" +
                " ORDER BY id";
        List<Chat> chatList = jdbcTemplate.query(sql,
                (rs, rowNum) -> new Chat(rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"))
                );
        return chatList;
	}

	@Override
	public int insert(Chat chat) {
        String sql = "INSERT INTO chat(question, answer)" +
                " VALUES(:question, :answer)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("question", chat.getQuestion());
        parameterSource.addValue("answer", chat.getAnswer());
        int rows = jdbcTemplate.update(sql, parameterSource);
        return rows;
	}

}
