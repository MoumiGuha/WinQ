/**
 * 
 */
package io.winq.mono.facade;

import java.util.List;

import io.winq.mono.dto.request.SubjectRequest;
import io.winq.mono.dto.response.SubjectResponse;
import io.winq.mono.exception.DataAlreadyExistsException;
import io.winq.mono.exception.DataNotFoundException;

/**
 * @author Admin
 *
 */
public interface SubjectFacade {

	List<SubjectResponse> getAllSubjects();

	SubjectResponse createSubject(SubjectRequest subjectRequest) throws DataNotFoundException, DataAlreadyExistsException;

}
