/**
 * 
 */
package io.winq.mono.service;

import io.winq.mono.dto.request.QuestionRequest;
import io.winq.mono.model.Question;

/**
 * @author Admin
 *
 */
public interface QuestionService {

	Question createQuestion(QuestionRequest questionRequest);

}
