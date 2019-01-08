/**
 * 
 */
package io.winq.mono.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.winq.mono.converter.SubjectConverter;
import io.winq.mono.dto.request.SubjectRequest;
import io.winq.mono.dto.response.SubjectResponse;
import io.winq.mono.exception.DataAlreadyExistsException;
import io.winq.mono.exception.DataNotFoundException;
import io.winq.mono.facade.SubjectFacade;
import io.winq.mono.model.Subject;
import io.winq.mono.service.SubjectService;

/**
 * @author Admin
 *
 */
@Component
public class SubjectFacadeImpl implements SubjectFacade {

	@Autowired
	private SubjectService subjectService;

	@Override
	public List<SubjectResponse> getAllSubjects() {

		// Validation
		// ...

		// Call Service
		List<Subject> subjects = subjectService.getAllSubjects();

		// Convert and Return

		List<SubjectResponse> subjectResponses = new ArrayList<>();

		for (Subject subject : subjects) {
			SubjectResponse subjectResponse = SubjectConverter.convert(subject);
			subjectResponses.add(subjectResponse);
		}

		return subjectResponses;
	}

	@Override
	public SubjectResponse createSubject(SubjectRequest subjectRequest)
			throws DataNotFoundException, DataAlreadyExistsException {

		// Validation
		if (subjectRequest == null) {
			throw new DataNotFoundException("Request Body cannot be null");
		}

		// Convert to Entity
		Subject subject = SubjectConverter.convert(subjectRequest);

		// Call Service
		Subject createdSubject = subjectService.createSubject(subject);

		// Convert to Dto
		SubjectResponse subjectResponse = SubjectConverter.convert(createdSubject);

		return subjectResponse;
	}
}