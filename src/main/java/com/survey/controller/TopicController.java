package com.survey.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.bean.Topics;
import com.survey.service.TopicService;


@RestController
@RequestMapping("/topics")
@CrossOrigin
public class TopicController {

	@Autowired
	TopicService service;
	
	@PostMapping("/addTopic")
	public String performAddTopic(@RequestBody Topics topic) {
		service.addTopic(topic);
		return "Topic added Successfully";
	}
	
	@PutMapping("/updateTopic")
	public String performUpdateTopic(@RequestBody Topics topic) {
		service.updateTopic(topic);
		return "Topic Updated Successfully";
	}
	
	@DeleteMapping("/deleteTopic/{topicId}")
	public String performDeleteTopic(@PathVariable("topicId") long topicId) throws Exception {
		service.deleteTopics(topicId);
		return "Topic Deleted Succefully";
	}
	
	@GetMapping("/getTopic/{topicId}")
	public Optional<Topics> performGetTopicById(@PathVariable("topicId") Long topicId) throws Exception{
		Optional<Topics> topic = service.getTopicById(topicId);
		return topic;
	}

	@GetMapping("/getAllTopics")
	public List<Topics> performGetAllTopics() {
		List<Topics> list = service.getAllTopics();
		return list;
	}
}
