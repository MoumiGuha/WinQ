/**
 * 
 */
package io.winq.mono.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.winq.mono.model.Option;

/**
 * @author Admin
 *
 */
public interface OptionRepository extends JpaRepository<Option, UUID> {

}
