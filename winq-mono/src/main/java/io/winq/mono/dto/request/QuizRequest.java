/**
 * 
 */
package io.winq.mono.dto.request;

import java.util.List;
import java.util.UUID;

import lombok.Data;

/**
 * @author Admin
 *
 */
@Data
public class QuizRequest {

	private String name;

	private List<UUID> subjectIds;

}
