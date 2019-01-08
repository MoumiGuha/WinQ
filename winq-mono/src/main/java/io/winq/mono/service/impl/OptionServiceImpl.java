package io.winq.mono.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.winq.mono.dto.request.OptionRequest;
import io.winq.mono.model.Option;
import io.winq.mono.model.Question;
import io.winq.mono.repository.OptionRepository;
import io.winq.mono.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionRepository optionRepository;

	@Override
	public Option createOption(OptionRequest optionRequest, Question question) {

		Option option = new Option();

		option.setIsCorrect(optionRequest.isCorrect());
		option.setQuestion(question);
		option.setValue(optionRequest.getValue());

		Option savedOption = optionRepository.save(option);

		return savedOption;
	}

}
