/**
 * 
 */
package io.winq.mono.dto.response;

import java.util.UUID;

import lombok.Data;

/**
 * @author Admin
 *
 */
@Data
public class OptionResponse {

	private UUID id;

	private String value;

	private Boolean isCorrect;

}
