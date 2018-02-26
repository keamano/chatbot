package com.example.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.Question;

@Repository
public class QuestionRepositoryDummy implements QuestionRepository {
	
	private List<Question> questionList = new ArrayList<Question>();
	
	QuestionRepositoryDummy() {
		questionList.add(new Question(1, "誰ですか", "ボットです"));
		questionList.add(new Question(2, "天気", "快晴です"));
		questionList.add(new Question(3, "こんにちは", "こんにちは"));
	}

	@Override
	public List<Question> findAll() {
		return questionList;
	}
	
	@Override
	public Question findById(Integer id) {
		for (Question question : questionList) {
			if (id == question.getId()) {
				return question;
			}
		}
		return null;
	}

	@Override
	public Question findByQuestion(String question) {
		for (Question questionEntity : questionList) {
			if (question.indexOf(questionEntity.getQuestion()) >= 0) {
				return questionEntity;
			}
		}
		return null;
	}

	@Override
	public int insert(Question question) {
		int nextId;
		if (questionList.isEmpty()) {
			nextId = 1;
		} else {
			int size = questionList.size();
			Question lastBot = questionList.get(size -1);
			int lastId = lastBot.getId();
			nextId = lastId + 1;
		}
		
		question.setId(nextId);
		questionList.add(question);
		
		return nextId;
	}

	@Override
	public int update(Question question) {
		Question targetBot = findById(question.getId());
		if (targetBot == null) {
			return -1;
		}
		
		targetBot.setQuestion(question.getQuestion());
		targetBot.setAnswer(question.getAnswer());
		
		return question.getId();
	}

	@Override
	public int delete(Question question) {
		Question targetBot = findById(question.getId());
		if (targetBot == null) {
			return -1;
		}

		questionList.remove(targetBot);
		
		return question.getId();
	}

}
