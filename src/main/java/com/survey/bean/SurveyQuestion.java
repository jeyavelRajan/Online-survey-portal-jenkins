package com.survey.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tbl_survey_questions")
public class SurveyQuestion {

    @Id
    @Column(name = "Survey_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long surveyId;

    @Column(name = "Topic_Id")
    private long topicId;

    @Column(name = "Survey")
    private String survey;

    @Column(name = "First_Option")
    private String firstOption;

    @Column(name = "Second_Option")
    private String secondOption;

    @Column(name = "Third_Option")
    private String thirdOption;

    @Column(name = "Fourth_Option")
    private String fourthOption;

    @Column(name = "Answer")
    private String answer;

	public SurveyQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SurveyQuestion(long surveyId, long topicId, String survey, String firstOption, String secondOption,
			String thirdOption, String fourthOption, String answer) {
		super();
		this.surveyId = surveyId;
		this.topicId = topicId;
		this.survey = survey;
		this.firstOption = firstOption;
		this.secondOption = secondOption;
		this.thirdOption = thirdOption;
		this.fourthOption = fourthOption;
		this.answer = answer;
	}

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getSurvey() {
		return survey;
	}

	public void setSurvey(String survey) {
		this.survey = survey;
	}

	public String getFirstOption() {
		return firstOption;
	}

	public void setFirstOption(String firstOption) {
		this.firstOption = firstOption;
	}

	public String getSecondOption() {
		return secondOption;
	}

	public void setSecondOption(String secondOption) {
		this.secondOption = secondOption;
	}

	public String getThirdOption() {
		return thirdOption;
	}

	public void setThirdOption(String thirdOption) {
		this.thirdOption = thirdOption;
	}

	public String getFourthOption() {
		return fourthOption;
	}

	public void setFourthOption(String fourthOption) {
		this.fourthOption = fourthOption;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "SurveyQuestion [surveyId=" + surveyId + ", topicId=" + topicId + ", survey=" + survey + ", firstOption="
				+ firstOption + ", secondOption=" + secondOption + ", thirdOption=" + thirdOption + ", fourthOption="
				+ fourthOption + ", answer=" + answer + "]";
	}

  
}
