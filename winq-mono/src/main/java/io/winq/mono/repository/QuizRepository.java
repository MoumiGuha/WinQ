/**
 * 
 */
package io.winq.mono.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.winq.mono.model.Quiz;

/**
 * @author Admin
 *
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID> {

}
