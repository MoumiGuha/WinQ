package io.winq.mono.facade.impl;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.winq.mono.converter.QuizConverter;
import io.winq.mono.dto.request.QuizRequest;
import io.winq.mono.dto.response.QuizResponse;
import io.winq.mono.exception.DataNotFoundException;
import io.winq.mono.exception.InvalidDataException;
import io.winq.mono.facade.QuizFacade;
import io.winq.mono.model.Quiz;
import io.winq.mono.service.QuizService;

/**
 * 
 * @author Admin
 *
 */
@Component
public class QuizFacadeImpl implements QuizFacade {

	@Autowired
	private QuizService quizService;

	@Override
	public QuizResponse generateQuiz(QuizRequest quizRequest) throws DataNotFoundException, InvalidDataException {

		if (quizRequest == null) {
			throw new DataNotFoundException("Request Body cannot be null");
		}

		if (quizRequest.getName() == null || StringUtils.isEmpty(quizRequest.getName())) {
			throw new InvalidDataException("Name cannot be null or empty");
		}

		if (quizRequest.getSubjectIds() == null) {
			throw new InvalidDataException("Subject Ids cannot be null");
		}
		if (quizRequest.getSubjectIds().isEmpty()) {
			throw new InvalidDataException("Subject Ids cannot be empty");
		}

		Quiz generatedQuiz = quizService.generateQuiz(quizRequest);

		QuizResponse quizResponse = QuizConverter.convert(generatedQuiz);

		return quizResponse;
	}

	@Override
	public QuizResponse getQuiz(UUID id) throws InvalidDataException, DataNotFoundException {

		if (id == null) {
			throw new InvalidDataException("Id cannot be null");
		}

		Quiz quiz;
		try {
			quiz = quizService.getQuiz(id);

		} catch (NoSuchElementException e) {
			throw new DataNotFoundException("No Data found for the given Id.");
		}

		QuizResponse quizResponse = QuizConverter.convert(quiz);

		return quizResponse;
	}

}
