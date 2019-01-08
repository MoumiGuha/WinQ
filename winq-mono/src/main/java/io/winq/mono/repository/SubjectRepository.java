/**
 * 
 */
package io.winq.mono.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.winq.mono.model.Subject;

/**
 * @author Admin
 *
 */
public interface SubjectRepository extends JpaRepository<Subject, UUID> {

	boolean existsByName(String name);

}
