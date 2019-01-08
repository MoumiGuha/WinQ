package io.winq.mono.converter;

import io.winq.mono.dto.response.QuestionResponse;
import io.winq.mono.dto.response.SubjectResponse;
import io.winq.mono.model.Question;

/**
 * 
 * @author Admin
 *
 */
public class QuestionConverter {

	public static QuestionResponse convert(Question question) {

		QuestionResponse questionResponse = new QuestionResponse();

		questionResponse.setId(question.getId());
		questionResponse.setQuestion(question.getQuestion());

		SubjectResponse subjectResponse = SubjectConverter.convert(question.getSubject());

		questionResponse.setSubjectResponse(subjectResponse);

		return questionResponse;
	}

}
