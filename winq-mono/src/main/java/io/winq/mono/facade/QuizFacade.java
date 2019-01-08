package io.winq.mono.facade;

import java.util.UUID;

import io.winq.mono.dto.request.QuizRequest;
import io.winq.mono.dto.response.QuizResponse;
import io.winq.mono.exception.DataNotFoundException;
import io.winq.mono.exception.InvalidDataException;

public interface QuizFacade {

	QuizResponse generateQuiz(QuizRequest quizRequest) throws DataNotFoundException, InvalidDataException;

	QuizResponse getQuiz(UUID id) throws InvalidDataException, DataNotFoundException;

}
