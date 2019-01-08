/**
 * 
 */
package io.winq.mono.service;

import java.util.NoSuchElementException;
import java.util.UUID;

import io.winq.mono.dto.request.QuizRequest;
import io.winq.mono.model.Quiz;

/**
 * @author Admin
 *
 */
public interface QuizService {

	Quiz generateQuiz(QuizRequest quizRequest);

	Quiz getQuiz(UUID id) throws NoSuchElementException;

}
