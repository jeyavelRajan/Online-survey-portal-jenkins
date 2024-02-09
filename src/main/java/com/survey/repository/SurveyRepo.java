package com.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.bean.SurveyQuestion;

@Repository

public interface SurveyRepo extends JpaRepository<SurveyQuestion, Long>{
	
	public List<SurveyQuestion> getSurveyByTopicId(long topicId);

}
