/**
 * 
 */
package io.winq.mono.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.winq.mono.converter.QuestionConverter;
import io.winq.mono.dto.response.OptionResponse;
import io.winq.mono.dto.response.QuestionResponse;
import io.winq.mono.dto.response.QuizResponse;
import io.winq.mono.model.Option;
import io.winq.mono.model.Question;
import io.winq.mono.model.Quiz;

/**
 * @author Admin
 *
 */
public class QuizConverter {

	public static QuizResponse convert(Quiz generatedQuiz) {

		QuizResponse quizResponse = new QuizResponse();

		quizResponse.setId(generatedQuiz.getId());
		quizResponse.setName(generatedQuiz.getName());

		List<QuestionResponse> questionResponses = new ArrayList<QuestionResponse>();

		for (Question question : generatedQuiz.getQuestions()) {

			QuestionResponse questionResponse = QuestionConverter.convert(question);

			Set<OptionResponse> optionResponses = new HashSet<OptionResponse>();

			for (Option option : question.getOptions()) {
				OptionResponse optionResponse = OptionConverter.convert(option);
				optionResponses.add(optionResponse);
			}

			questionResponse.setOptionResponses(optionResponses);

			questionResponses.add(questionResponse);
		}

		quizResponse.setQuestionResponses(questionResponses);

		return quizResponse;
	}

}
