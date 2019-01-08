/**
 * 
 */
package io.winq.mono.dto.request;

import java.util.Set;
import java.util.UUID;

import lombok.Data;

/**
 * @author Admin
 *
 */
@Data
public class QuestionRequest {

	private String question;

	private Set<OptionRequest> optionRequests;
	
	private UUID subjectId;
}
