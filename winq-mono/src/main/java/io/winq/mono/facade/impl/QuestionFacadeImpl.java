/**
 * 
 */
package io.winq.mono.facade.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.winq.mono.converter.QuestionConverter;
import io.winq.mono.dto.request.QuestionRequest;
import io.winq.mono.dto.response.OptionResponse;
import io.winq.mono.dto.response.QuestionResponse;
import io.winq.mono.exception.DataAlreadyExistsException;
import io.winq.mono.exception.DataNotFoundException;
import io.winq.mono.exception.InvalidDataException;
import io.winq.mono.facade.OptionFacade;
import io.winq.mono.facade.QuestionFacade;
import io.winq.mono.model.Question;
import io.winq.mono.service.QuestionService;

/**
 * @author Admin
 *
 */
@Component
public class QuestionFacadeImpl implements QuestionFacade {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private OptionFacade optionFacade;

	@Override
	public QuestionResponse createQuestion(QuestionRequest questionRequest)
			throws DataNotFoundException, DataAlreadyExistsException, InvalidDataException {

		if (questionRequest == null) {
			throw new DataNotFoundException("Request Body cannot be null");
		}

		if (questionRequest.getQuestion() == null || StringUtils.isEmpty(questionRequest.getQuestion())) {
			throw new InvalidDataException("Question cannot be null or empty");
		}

		if (questionRequest.getOptionRequests() == null) {
			throw new InvalidDataException("OptionRequests cannot be null or empty");
		}

		if (questionRequest.getOptionRequests().isEmpty()) {
			throw new InvalidDataException("OptionRequests cannot be null or empty");
		}

		Question question = questionService.createQuestion(questionRequest);

		Set<OptionResponse> optionResponses = optionFacade.createOptions(questionRequest.getOptionRequests(),
				question);

		QuestionResponse questionResponse = QuestionConverter.convert(question);
		questionResponse.setOptionResponses(optionResponses);

		return questionResponse;
	}

}