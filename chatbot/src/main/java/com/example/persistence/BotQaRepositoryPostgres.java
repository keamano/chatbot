package com.example.persistence;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.BotQa;

@Repository
public class BotQaRepositoryPostgres implements BotQaRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public BotQaRepositoryPostgres(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BotQa> findAll() {
        String sql = "SELECT id, question, answer" +
                " FROM bot_qa" +
                " ORDER BY id";
        List<BotQa> botQaList = jdbcTemplate.query(sql,
                (rs, rowNum) -> new BotQa(rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"))
                );
        return botQaList;
    }

    @Override
    public BotQa findById(Integer id) {
        String sql = "SELECT id, question, answer" +
                " FROM bot_qa" +
                " WHERE id = " + String.valueOf(id);
        List<BotQa> botQaList = jdbcTemplate.query(sql,
                (rs, rowNum) -> new BotQa(rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"))
                );
        if (botQaList.isEmpty()) {
            return null;
        }
        return botQaList.get(0);
    }

    @Override
    public BotQa findByQuestion(String question) {
        String sql = "SELECT id, question, answer" +
                " FROM bot_qa" +
                " WHERE question LIKE '%" + question + "%'" +
                " ORDER BY id" +
                " LIMIT 1";
        List<BotQa> botQaList = jdbcTemplate.query(sql,
                (rs, rowNum) -> new BotQa(rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer"))
                );
        if (botQaList.isEmpty()) {
            return null;
        }
        return botQaList.get(0);
    }

    @Override
    public int insert(BotQa botQa) {
        String sql = "INSERT INTO bot_qa(question, answer)" +
                " VALUES(:question, :answer)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("question", botQa.getQuestion());
        parameterSource.addValue("answer", botQa.getAnswer());
        int rows = jdbcTemplate.update(sql, parameterSource);
        return rows;
    }

    @Override
    public int update(BotQa botQa) {
        String sql = "UPDATE bot_qa" +
                " SET question = :question, answer = :answer" +
                " WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("question", botQa.getQuestion());
        parameterSource.addValue("answer", botQa.getAnswer());
        parameterSource.addValue("id", botQa.getId());
        int rows = jdbcTemplate.update(sql, parameterSource);
        return rows;
    }

    @Override
    public int delete(BotQa botQa) {
        String sql = "DELETE FROM bot_qa" +
                " WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", botQa.getId());
        int rows = jdbcTemplate.update(sql, parameterSource);
        return rows;
    }

}
