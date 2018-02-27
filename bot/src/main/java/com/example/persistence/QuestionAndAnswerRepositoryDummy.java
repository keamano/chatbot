package com.example.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.QuestionAndAnswer;

@Repository
public class QuestionAndAnswerRepositoryDummy implements QuestionAndAnswerRepository {

    private List<QuestionAndAnswer> questionAndAnswerList = new ArrayList<QuestionAndAnswer>();

    QuestionAndAnswerRepositoryDummy() {
        questionAndAnswerList.add(new QuestionAndAnswer(1, "誰ですか", "ボットです"));
        questionAndAnswerList.add(new QuestionAndAnswer(2, "天気", "快晴です"));
        questionAndAnswerList.add(new QuestionAndAnswer(3, "こんにちは", "こんにちは"));
    }

    @Override
    public List<QuestionAndAnswer> findAll() {
        return questionAndAnswerList;
    }

    @Override
    public QuestionAndAnswer findById(Integer id) {
        for (QuestionAndAnswer questionAndAnswer : questionAndAnswerList) {
            if (id == questionAndAnswer.getId()) {
                return questionAndAnswer;
            }
        }
        return null;
    }

    @Override
    public QuestionAndAnswer findByQuestion(String question) {
        for (QuestionAndAnswer questionAndAnswer : questionAndAnswerList) {
            if (question.indexOf(questionAndAnswer.getQuestion()) >= 0) {
                return questionAndAnswer;
            }
        }
        return null;
    }

    @Override
    public int insert(QuestionAndAnswer questionAndAnswer) {
        int nextId;
        if (questionAndAnswerList.isEmpty()) {
            nextId = 1;
        } else {
            int size = questionAndAnswerList.size();
            QuestionAndAnswer lastBot = questionAndAnswerList.get(size - 1);
            int lastId = lastBot.getId();
            nextId = lastId + 1;
        }

        questionAndAnswer.setId(nextId);
        questionAndAnswerList.add(questionAndAnswer);

        return nextId;
    }

    @Override
    public int update(QuestionAndAnswer questionAndAnswer) {
        QuestionAndAnswer targetBot = findById(questionAndAnswer.getId());
        if (targetBot == null) {
            return -1;
        }

        targetBot.setQuestion(questionAndAnswer.getQuestion());
        targetBot.setAnswer(questionAndAnswer.getAnswer());

        return questionAndAnswer.getId();
    }

    @Override
    public int delete(QuestionAndAnswer question) {
        QuestionAndAnswer targetBot = findById(question.getId());
        if (targetBot == null) {
            return -1;
        }

        questionAndAnswerList.remove(targetBot);

        return question.getId();
    }

}
