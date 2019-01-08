/**
 * 
 */
package io.winq.mono.dto.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Admin
 *
 */
@Getter
@Setter
public class SubjectRequest {

	@NotEmpty
	private String name;

	private List<QuestionRequest> questionRequests;
}
