/**
 * 
 */
package io.winq.mono.dto.response;

import java.util.Set;
import java.util.UUID;

import lombok.Data;

/**
 * @author Admin
 *
 */
@Data
public class QuestionResponse {

	private UUID id;

	private String question;

	private SubjectResponse subjectResponse;

	private Set<OptionResponse> optionResponses;
}
