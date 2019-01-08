package io.winq.mono.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.winq.mono.dto.request.QuestionRequest;
import io.winq.mono.model.Question;
import io.winq.mono.model.Subject;
import io.winq.mono.repository.QuestionRepository;
import io.winq.mono.repository.SubjectRepository;
import io.winq.mono.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public Question createQuestion(QuestionRequest questionRequest) {

		Question question = new Question();

		question.setQuestion(questionRequest.getQuestion());

		Optional<Subject> subject = subjectRepository.findById(questionRequest.getSubjectId());

		question.setSubject(subject.get());

		Question createdQuestion = questionRepository.save(question);

		return createdQuestion;
	}
}
