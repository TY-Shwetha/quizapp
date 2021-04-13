package com.tyss.quizapp.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class QuestionsBean implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionId;
	
	@Column(name = "question")
	private String question;

	@Column(name = "answer")
	private String answer;
	
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	@ManyToOne
	@JoinColumn(name="topicId")
	private TopicsBean quizTopic;
}
