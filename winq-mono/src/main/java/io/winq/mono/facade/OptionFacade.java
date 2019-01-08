package io.winq.mono.facade;

import java.util.Set;

import io.winq.mono.dto.request.OptionRequest;
import io.winq.mono.dto.response.OptionResponse;
import io.winq.mono.exception.InvalidDataException;
import io.winq.mono.model.Question;

public interface OptionFacade {

	Set<OptionResponse> createOptions(Set<OptionRequest> optionRequests, Question question) throws InvalidDataException;

}
