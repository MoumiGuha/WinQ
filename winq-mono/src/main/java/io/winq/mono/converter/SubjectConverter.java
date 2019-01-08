package io.winq.mono.converter;

import io.winq.mono.dto.request.SubjectRequest;
import io.winq.mono.dto.response.SubjectResponse;
import io.winq.mono.model.Subject;

public class SubjectConverter {

	public static SubjectResponse convert(Subject subject) {

		SubjectResponse subjectResponse = new SubjectResponse();

		subjectResponse.setId(subject.getId());
		subjectResponse.setName(subject.getName());

		return subjectResponse;
	}

	public static Subject convert(SubjectRequest subjectRequest) {

		Subject subject = new Subject();

		subject.setName(subjectRequest.getName());

		return subject;
	}

}
