package com.example.persistence;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.Bot;

@Repository
public class BotRepositoryPostgres implements BotRepository {
	
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
    public BotRepositoryPostgres(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public List<Bot> findAll() {
        String sql = "SELECT id, question, answer" +
                " FROM bot" +
                " ORDER BY id";
        List<Bot> botList = jdbcTemplate.query(sql,
                (rs, rowNum) -> new Bot(rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"))
                );
        return botList;
	}
	
	@Override
	public Bot findById(Integer id) {
        String sql = "SELECT id, question, answer" +
                " FROM bot" +
                " WHERE id = " + String.valueOf(id);
        List<Bot> botList = jdbcTemplate.query(sql,
                (rs, rowNum) -> new Bot(rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"))
                );
        if (botList.isEmpty()) {
        	return null;
        }
        return botList.get(0);
	}

	@Override
	public Bot findByQuestion(String question) {
        String sql = "SELECT id, question, answer" +
                " FROM bot" +
                " WHERE question LIKE '%" + question + "%'" +
                " ORDER BY id" +
                " LIMIT 1";
        List<Bot> botList = jdbcTemplate.query(sql,
                (rs, rowNum) -> new Bot(rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"))
                );
        if (botList.isEmpty()) {
        	return null;
        }
        return botList.get(0);
	}

	@Override
	public int insert(Bot bot) {
        String sql = "INSERT INTO bot(question, answer)" +
                " VALUES(:question, :answer)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("question", bot.getQuestion());
        parameterSource.addValue("answer", bot.getAnswer());
        int rows = jdbcTemplate.update(sql, parameterSource);
        return rows;
	}

	@Override
	public int update(Bot bot) {
        String sql = "UPDATE bot" +
        		" SET question = :question, answer = :answer" +
        		" WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("question", bot.getQuestion());
        parameterSource.addValue("answer", bot.getAnswer());
        parameterSource.addValue("id", bot.getId());
        int rows = jdbcTemplate.update(sql, parameterSource);
        return rows;
	}

	@Override
	public int delete(Bot bot) {
        String sql = "DELETE FROM bot" +
        		" WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", bot.getId());
        int rows = jdbcTemplate.update(sql, parameterSource);
        return rows;
	}

}
