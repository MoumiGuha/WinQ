package io.winq.mono.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String question;

	@ManyToOne
	@JoinColumn(name = "subject_id", foreignKey = @ForeignKey(name = "question_subject_fk"))
	private Subject subject;

	@ManyToOne
	@JoinColumn(name = "quiz_id", foreignKey = @ForeignKey(name = "question_quiz_fk"))
	private Quiz quiz;

	@OneToMany(mappedBy = "question")
	private Set<Option> options;

}
