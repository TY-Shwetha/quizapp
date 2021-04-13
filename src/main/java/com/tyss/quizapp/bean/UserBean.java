package com.tyss.quizapp.bean;

import java.io.Serializable;

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
@Table(name="UserBean")
public class UserBean implements Serializable{


	@Id
	@Column(name="userid")
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@OneToMany(mappedBy = "userBean", cascade = CascadeType.ALL)
	private int userid;
	
	@Column(name="uname")
	private String uname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
    private String password;
    
}
