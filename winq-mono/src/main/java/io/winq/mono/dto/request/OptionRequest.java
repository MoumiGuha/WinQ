/**
 * 
 */
package io.winq.mono.dto.request;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Admin
 *
 */

@Data
public class OptionRequest {

	@NotEmpty
	private String value;

	@JsonProperty
	private boolean isCorrect;
}
