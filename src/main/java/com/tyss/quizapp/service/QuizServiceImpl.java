package com.tyss.quizapp.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.quizapp.bean.UserBean;
import com.tyss.quizapp.dao.QuizDAO;
import com.tyss.quizapp.dao.QuizDAOImpl;
import com.tyss.quizapp.main.QuizApp;

public class QuizServiceImpl implements QuizService{

	Scanner scan=new Scanner(System.in);
	QuizDAO quizdao=new QuizDAOImpl();
	@Override
	public void login() {

		System.out.println("Enter the mail");
		String email=scan.next();
		System.out.println("Enter the Password");
		String pswd=scan.next();

		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;

		try {

			entityManagerFactory=Persistence.createEntityManagerFactory("quizProject");
			entityManager=entityManagerFactory.createEntityManager();
			String sql="from UserBean where email=:email ";

			Query query	=entityManager.createQuery(sql);
			query.setParameter("email", email);
			List<UserBean> list =query.getResultList();
			
			if(list.size()>0) {
				for (UserBean user: list) {
					String psw =user.getPassword();
					if(psw.equals(pswd)) {
						System.out.println("Checking.........");
						quizdao.login(user.getUserid());

					}else {
						System.out.println("Invalid Password");
						System.out.println("Please enter valid password..");
						login();	
					}
				}
			}else {
				System.out.println("Invalid mail");
				System.out.println("Please press 2 for registering user account ..");
				QuizApp.calling();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			if(entityManagerFactory!=null) {
				entityManager.close();
			}if (entityManagerFactory!=null) {
				entityManagerFactory.close();
			}
		}
	}

	@Override
	public void register() {

		quizdao.register();
	}

}
