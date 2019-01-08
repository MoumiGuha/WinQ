package io.winq.mono.service;

import io.winq.mono.dto.request.OptionRequest;
import io.winq.mono.model.Option;
import io.winq.mono.model.Question;

public interface OptionService {

	Option createOption(OptionRequest optionRequest, Question question);

}
