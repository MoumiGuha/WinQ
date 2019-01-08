/**
 * 
 */
package io.winq.mono.service.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.winq.mono.dto.request.QuizRequest;
import io.winq.mono.model.Question;
import io.winq.mono.model.Quiz;
import io.winq.mono.repository.QuestionRepository;
import io.winq.mono.repository.QuizRepository;
import io.winq.mono.service.QuizService;

/**
 * @author Admin
 *
 */
@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Quiz generateQuiz(QuizRequest quizRequest) {

		Quiz quiz = new Quiz();

		quiz.setName(quizRequest.getName());

		int numberOfSubjects = quizRequest.getSubjectIds().size();

		Set<Question> questions = new HashSet<Question>(numberOfSubjects);

		for (UUID subjectId : quizRequest.getSubjectIds()) {

			List<Question> questionBank = questionRepository.findBySubjectId(subjectId);

			Collections.shuffle(questionBank);

			if (questionBank.size() > 5) {
				questions.addAll(questionBank.subList(0, 5));
			} else {
				questions.addAll(questionBank.subList(0, questionBank.size() - 1));
			}
		}

		quiz.setQuestions(questions);

		Quiz generatedQuiz = quizRepository.save(quiz);

		for (Question question : questions) {
			question.setQuiz(generatedQuiz);
			questionRepository.save(question);
		}

		return generatedQuiz;
	}

	@Override
	public Quiz getQuiz(UUID id) throws NoSuchElementException {

		Quiz quiz = quizRepository.findById(id).get();

		return quiz;
	}
}
