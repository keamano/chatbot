package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Question;
import com.example.persistence.QuestionRepository;

@Service
public class QuestionAdminServiceImpl implements QuestionAdminService {
	
	private final QuestionRepository questionRepository;
	
	public QuestionAdminServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Question> findAll() {
		return questionRepository.findAll();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Question findById(Integer id) {
		return questionRepository.findById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Question question) {
		questionRepository.insert(question);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Question question) {
		questionRepository.update(question);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Question question) {
		questionRepository.delete(question);
	}

}
