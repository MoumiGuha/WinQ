package io.winq.mono.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.winq.mono.exception.DataAlreadyExistsException;
import io.winq.mono.model.Subject;
import io.winq.mono.repository.SubjectRepository;
import io.winq.mono.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAllSubjects() {

		List<Subject> subjects = subjectRepository.findAll();

		return subjects;
	}

	@Override
	public Subject createSubject(Subject subject) throws DataAlreadyExistsException {

		if (subjectRepository.existsByName(subject.getName())) {
			throw new DataAlreadyExistsException("Subject already exists");
		}

		Subject savedSubject = subjectRepository.save(subject);

		return savedSubject;
	}

}
