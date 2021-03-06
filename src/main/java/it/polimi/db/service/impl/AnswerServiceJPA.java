package it.polimi.db.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.polimi.db.dao.AnswerRepository;
import it.polimi.db.entity.Answer;
import it.polimi.db.service.AnswerService;

@Service
public class AnswerServiceJPA implements AnswerService {

	@Autowired
	private AnswerRepository answerRepo;

	@Override
	public List<Answer> findByUser(Integer user_id) {
		return answerRepo.findByUserId(user_id);
	}

	@Override
	public List<Answer> findByQuestionnaire(Integer questionnaire_id) {
		return answerRepo.findByQuestionnaireId(questionnaire_id);
	}

	@Override
	public List<Answer> findByQuestionAndQuestionnaire(Integer question_id, Integer questionnaire_id) {
		return answerRepo.findByQuestionIdAndQuestionnaireId(question_id, questionnaire_id);
	}
	
	@Override
	public Optional<Answer> findByUserAndQuestionnaireAndQuestion(Integer user_id, Integer questionnaire_id,
			Integer question_id) {
		return answerRepo.findByUserIdAndQuestionnaireIdAndQuestionId(user_id, questionnaire_id, question_id);
	}

	@Override
	public Answer createAnswer(Answer answer) {
		return answerRepo.save(answer);
	}

	@Override
	public Answer updateAnswer(Answer answer) {
		return answerRepo.saveAndFlush(answer);
	}

	@Override
	public List<Answer> findByUserAndQuestionnaire(Integer userId, Integer questionnaireId) {
		return answerRepo.findByUserIdAndQuestionnaireId(userId, questionnaireId);
	}
	
	@Override
	public Answer removeAnswer(Answer answer) {
		answerRepo.delete(answer);
		return answer;
	}
}
