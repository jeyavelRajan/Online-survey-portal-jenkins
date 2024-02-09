package com.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.survey.bean.SurveyQuestion;
import com.survey.bean.Users;
import com.survey.service.SurveyService;


@RestController
@CrossOrigin
@RequestMapping("/survey")
public class SurveyController {

		
		@Autowired
		SurveyService service;
		
		@PostMapping("/addSurvey")
		public  ResponseEntity<String> performaddSurvey(@RequestPart("file") MultipartFile file) {
			 try {
				 
				 service.addSurvey(file);
			 }catch(Exception e){
				 e.printStackTrace();
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
			 }return ResponseEntity.ok("File uploaded successfully");
		}
		
		@DeleteMapping("/deleteSurvey/{surveyId}")
		public String performDeleteSurvey(@PathVariable("surveyId") long surveyId) throws Exception {
			service.deleteSurvey(surveyId);
			return "Survey Deleted Succefully";
		}
		

		@PutMapping("/updateSurvey")
		public void performUpdateQuiz(@RequestBody SurveyQuestion survey) throws Exception {
			service.updateSurvey(survey);
		}



		
		@GetMapping("/getSurvey/{surveyId}")
		public SurveyQuestion performGetSurveyById(@PathVariable("surveyId") Long surveyId) throws Exception{
			SurveyQuestion quiz = service.getSurveyById(surveyId);
			return quiz;
		}

		@GetMapping("/getAllSurveyQuestion")
		public List<SurveyQuestion> performGetAllSurvey() {
			List<SurveyQuestion> list = service.getAllQuizzes();
			return list;
		}
		
		@GetMapping("/getsurveyByTopicId/{topicId}")
		public List<SurveyQuestion> performgetSurveyById(@PathVariable("topicId") long topicId) {
			List<SurveyQuestion> list = service.getSurveyByTopicId(topicId);
			return list;
		}
		

}

