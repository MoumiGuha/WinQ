package io.winq.mono.controller;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.winq.mono.dto.request.SubjectRequest;
import io.winq.mono.dto.request.SubjectUpdateRequest;
import io.winq.mono.dto.response.SubjectResponse;
import io.winq.mono.exception.DataAlreadyExistsException;
import io.winq.mono.exception.DataNotFoundException;
import io.winq.mono.facade.SubjectFacade;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectFacade subjectFacade;

	@PostMapping()
	public ResponseEntity<?> createSubject(@RequestBody SubjectRequest subjectRequest)
			throws DataNotFoundException, DataAlreadyExistsException {

		SubjectResponse subjectResponse = subjectFacade.createSubject(subjectRequest);

		return ResponseEntity.ok(subjectResponse);
	}

	@PostMapping("/all")
	public ResponseEntity<?> createAllSubjects(@RequestBody Set<SubjectRequest> subjectRequests) {

		return null;
	}

	@PatchMapping("/{subjectId}/update")
	public ResponseEntity<?> updateSubject(@RequestBody SubjectUpdateRequest subjectUpdateRequest,
			@RequestParam UUID subjectId) {

		return null;
	}

	@PatchMapping("/{id}/disable")
	public ResponseEntity<?> disableSubject(@RequestParam UUID id) {

		return null;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllSubjects() {

		List<SubjectResponse> subjectResponses = subjectFacade.getAllSubjects();

		return ResponseEntity.ok(subjectResponses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getSubject(@RequestParam UUID id) {

		return null;
	}
}
