package com.survey.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.bean.Report;

@Repository
public interface ReportRepo extends JpaRepository<Report, Long>{
	
}
