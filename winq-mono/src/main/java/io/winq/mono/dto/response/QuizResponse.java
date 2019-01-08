package io.winq.mono.dto.response;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class QuizResponse {

	private UUID id;

	private String name;

	private List<QuestionResponse> questionResponses;
}
