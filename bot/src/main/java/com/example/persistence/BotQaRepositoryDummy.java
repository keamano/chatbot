package com.example.persistence;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.BotQa;

//@Repository
public class BotQaRepositoryDummy implements BotQaRepository {

    private List<BotQa> botQaList = new ArrayList<BotQa>();

    BotQaRepositoryDummy() {
        botQaList.add(new BotQa(1, "誰ですか", "ボットです"));
        botQaList.add(new BotQa(2, "天気", "快晴です"));
        botQaList.add(new BotQa(3, "こんにちは", "こんにちは"));
    }

    @Override
    public List<BotQa> findAll() {
        return botQaList;
    }

    @Override
    public BotQa findById(Integer id) {
        for (BotQa botQa : botQaList) {
            if (id == botQa.getId()) {
                return botQa;
            }
        }
        return null;
    }

    @Override
    public BotQa findByQuestion(String question) {
        for (BotQa botQa : botQaList) {
            if (question.indexOf(botQa.getQuestion()) >= 0) {
                return botQa;
            }
        }
        return null;
    }

    @Override
    public int insert(BotQa botQa) {
        int nextId;
        if (botQaList.isEmpty()) {
            nextId = 1;
        } else {
            int size = botQaList.size();
            BotQa lastBot = botQaList.get(size - 1);
            int lastId = lastBot.getId();
            nextId = lastId + 1;
        }

        botQa.setId(nextId);
        botQaList.add(botQa);

        return nextId;
    }

    @Override
    public int update(BotQa botQa) {
        BotQa targetBot = findById(botQa.getId());
        if (targetBot == null) {
            return -1;
        }

        targetBot.setQuestion(botQa.getQuestion());
        targetBot.setAnswer(botQa.getAnswer());

        return botQa.getId();
    }

    @Override
    public int delete(BotQa botQa) {
        BotQa targetBot = findById(botQa.getId());
        if (targetBot == null) {
            return -1;
        }

        botQaList.remove(targetBot);

        return botQa.getId();
    }

}
