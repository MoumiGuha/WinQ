/**
 * 
 */
package io.winq.mono.facade;

import io.winq.mono.dto.request.QuestionRequest;
import io.winq.mono.dto.response.QuestionResponse;
import io.winq.mono.exception.DataAlreadyExistsException;
import io.winq.mono.exception.DataNotFoundException;
import io.winq.mono.exception.InvalidDataException;

/**
 * @author Admin
 *
 */
public interface QuestionFacade {

	QuestionResponse createQuestion(QuestionRequest questionRequest)
			throws DataNotFoundException, DataAlreadyExistsException, InvalidDataException;

}
