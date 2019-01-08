/**
 * 
 */
package io.winq.mono.facade.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.winq.mono.converter.OptionConverter;
import io.winq.mono.dto.request.OptionRequest;
import io.winq.mono.dto.response.OptionResponse;
import io.winq.mono.exception.InvalidDataException;
import io.winq.mono.facade.OptionFacade;
import io.winq.mono.model.Option;
import io.winq.mono.model.Question;
import io.winq.mono.service.OptionService;

/**
 * @author Admin
 *
 */
@Component
public class OptionFacadeImpl implements OptionFacade {

	@Autowired
	private OptionService optionService;

	@Override
	public Set<OptionResponse> createOptions(Set<OptionRequest> optionRequests, Question question)
			throws InvalidDataException {

		if (question == null) {
			throw new InvalidDataException("Question cannot be null or empty");
		}

		if (optionRequests == null) {
			throw new InvalidDataException("OptionRequests cannot be null or empty");
		}

		if (optionRequests.isEmpty()) {
			throw new InvalidDataException("OptionRequests cannot be null or empty");
		}

		Set<OptionResponse> optionResponses = new HashSet<OptionResponse>();

		for (OptionRequest optionRequest : optionRequests) {

			Option option = optionService.createOption(optionRequest, question);

			OptionResponse optionResponse = OptionConverter.convert(option);

			optionResponses.add(optionResponse);
		}

		return optionResponses;
	}

}
