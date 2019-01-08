/**
 * 
 */
package io.winq.mono.converter;

import io.winq.mono.dto.response.OptionResponse;
import io.winq.mono.model.Option;

/**
 * @author Admin
 *
 */
public class OptionConverter {

	public static OptionResponse convert(Option option) {

		OptionResponse optionResponse = new OptionResponse();

		optionResponse.setId(option.getId());
		optionResponse.setValue(option.getValue());
		optionResponse.setIsCorrect(option.getIsCorrect());

		return optionResponse;
	}

}
