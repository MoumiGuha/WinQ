/**
 * 
 */
package io.winq.mono.service;

import java.util.List;

import io.winq.mono.exception.DataAlreadyExistsException;
import io.winq.mono.model.Subject;

/**
 * @author Admin
 *
 */
public interface SubjectService {

	List<Subject> getAllSubjects();

	Subject createSubject(Subject subject) throws DataAlreadyExistsException;

}
