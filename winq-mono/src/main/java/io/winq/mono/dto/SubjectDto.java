package io.winq.mono.dto;

import java.util.Set;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDto {

	private UUID id;

	private String name;

	private Set<QuestionDto> questionDtos;
}
