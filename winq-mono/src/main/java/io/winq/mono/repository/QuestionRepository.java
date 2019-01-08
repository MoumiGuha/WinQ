/**
 * 
 */
package io.winq.mono.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.winq.mono.model.Question;

/**
 * @author Admin
 *
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {

	List<Question> findBySubjectId(UUID id);

}
