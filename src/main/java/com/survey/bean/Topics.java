package com.survey.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_topics")
public class Topics {
	
	@Id
	@Column(name = "Topic_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long topicId;
	
	@Column(name = "Topic_Name")
	private String topicName;

	public Topics() {
		super();
	}

	public Topics(long topicId, String topicName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	
	}

