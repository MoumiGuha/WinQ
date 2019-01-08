package io.winq.mono.controller;

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

import io.winq.mono.dto.request.QuestionRequest;
import io.winq.mono.dto.request.UpdateQuestionRequest;
import io.winq.mono.dto.response.QuestionResponse;
import io.winq.mono.exception.DataAlreadyExistsException;
import io.winq.mono.exception.DataNotFoundException;
import io.winq.mono.exception.InvalidDataException;
import io.winq.mono.facade.QuestionFacade;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionFacade questionFacade;

	@PostMapping()
	public ResponseEntity<?> createQuestion(@RequestBody QuestionRequest questionRequest)
			throws DataNotFoundException, DataAlreadyExistsException, InvalidDataException {

		QuestionResponse questionResponse = questionFacade.createQuestion(questionRequest);

		return ResponseEntity.ok(questionResponse);
	}

	@PostMapping("/all")
	public ResponseEntity<?> createAllQuestions(@RequestBody Set<QuestionRequest> questionRequests) {

		return null;
	}

	@PatchMapping("/{id}/update")
	public ResponseEntity<?> updateQuestion(@RequestBody UpdateQuestionRequest updateQuestionRequest,
			@RequestParam UUID id) {

		return null;
	}

	@PatchMapping("/{id}/disable")
	public ResponseEntity<?> disableQuestion(@RequestParam UUID id) {

		return null;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllQuestions() {

		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getQuestion(@RequestParam UUID id) {

		return null;
	}
}
