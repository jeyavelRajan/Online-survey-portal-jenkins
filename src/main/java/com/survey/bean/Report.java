package com.survey.bean;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_report")
public class Report {
	
	@Id
	@Column(name = "Report_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long reportId;
	
	@Column(name = "User_Id")
	private long userId;
	
	@Column(name = "Topic_Id")
	private long topicId;
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param reportId
	 * @param userId
	 * @param topicId
	 * @param score
	 * @param feedBack
	 */
	public Report(long reportId, long userId, long topicId) {
		super();
		this.reportId = reportId;
		this.userId = userId;
		this.topicId = topicId;

	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	

}

