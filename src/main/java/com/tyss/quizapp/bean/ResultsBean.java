package com.tyss.quizapp.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Data
@Entity
public class ResultsBean implements Serializable{

	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name="resultid")
	private int resultid;
	
	@Column(name="result")
	private int result;

	@ManyToOne
	@JoinColumn(name="userid")
	private UserBean userBean;
	
	@ManyToOne
	@JoinColumn(name="topicId")
	private TopicsBean quizTopic;
}
