package io.winq.mono.controller;

import java.util.Set;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.winq.mono.dto.OptionDto;
import io.winq.mono.dto.UpdateOptionDto;

@RestController
@RequestMapping("/option")
public class OptionController {

	@PostMapping()
	public ResponseEntity<?> createOption(OptionDto optionDto) {

		return null;
	}

	@PostMapping("/all")
	public ResponseEntity<?> createAllOptions(Set<OptionDto> optionDtos) {

		return null;
	}

	@PatchMapping("/{id}/update")
	public ResponseEntity<?> updateOption(@RequestBody UpdateOptionDto updateOptionDto, @RequestParam UUID id) {

		return null;
	}

	@PatchMapping("/{id}/disable")
	public ResponseEntity<?> disableOption(@RequestParam UUID id) {

		return null;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllOptions() {

		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOption(@RequestParam UUID id) {

		return null;
	}
}
