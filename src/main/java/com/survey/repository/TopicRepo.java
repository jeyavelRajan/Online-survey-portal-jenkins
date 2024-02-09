package com.survey.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.bean.Topics;


@Repository
public interface TopicRepo extends JpaRepository<Topics, Long>{
	
}