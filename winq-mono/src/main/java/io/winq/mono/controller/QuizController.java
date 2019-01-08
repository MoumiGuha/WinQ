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

import io.winq.mono.dto.QuizDto;
import io.winq.mono.dto.UpdateQuizDto;
import io.winq.mono.dto.request.QuizRequest;
import io.winq.mono.dto.response.QuizResponse;
import io.winq.mono.exception.DataNotFoundException;
import io.winq.mono.exception.InvalidDataException;
import io.winq.mono.facade.QuizFacade;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizFacade quizFacade;

	@PostMapping()
	public ResponseEntity<?> generateQuiz(@RequestBody QuizRequest quizRequest)
			throws DataNotFoundException, InvalidDataException {

		QuizResponse quizResponse = quizFacade.generateQuiz(quizRequest);

		return ResponseEntity.ok(quizResponse);
	}

	@PostMapping("/all")
	public ResponseEntity<?> createAllQuizzes(Set<QuizDto> quizDtos) {

		return null;
	}

	@PatchMapping("/{id}/update")
	public ResponseEntity<?> updateQuiz(@RequestBody UpdateQuizDto updateQuizDto, @RequestParam UUID id) {

		return null;
	}

	@PatchMapping("/{id}/disable")
	public ResponseEntity<?> disableQuiz(@RequestParam UUID id) {

		return null;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllQuizzes() {

		return null;
	}

	@GetMapping()
	public ResponseEntity<?> getQuiz(@RequestParam UUID id) throws InvalidDataException, DataNotFoundException {

		QuizResponse quizResponse = quizFacade.getQuiz(id);

		return ResponseEntity.ok(quizResponse);
	}
}
