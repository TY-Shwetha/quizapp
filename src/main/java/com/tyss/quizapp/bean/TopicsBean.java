package com.tyss.quizapp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class TopicsBean implements Serializable{

	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name="topicId")
	private int topicId;
	
	@Column(name="topicName")
	private String topicName;

	@OneToMany(mappedBy = "quizTopic",cascade = CascadeType.ALL)
	private List<QuestionsBean> question = new ArrayList<QuestionsBean>();
}
