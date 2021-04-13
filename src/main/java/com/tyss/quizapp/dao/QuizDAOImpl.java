package com.tyss.quizapp.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.quizapp.bean.QuestionsBean;
import com.tyss.quizapp.bean.ResultsBean;
import com.tyss.quizapp.bean.TopicsBean;
import com.tyss.quizapp.bean.UserBean;

public class QuizDAOImpl implements QuizDAO{

	Scanner scan=new Scanner(System.in);

	public void testOn(int userid) {
		while(true) {
			Scanner scan=new Scanner(System.in);		
			System.out.println("Press 1 for Java ");
			System.out.println("Press 2 for Html ");
			System.out.println("Press 3 for Sql");
			int input=scan.nextInt();

			switch(input) {
			case 1:
				java(userid);
				break;

			case 2:
				html(userid);
				break;
			case 3:
				sql(userid);
				break;

			case 4:
				System.exit(0);
				break;
			}
		}
	}

	@Override
	public void login(int userid) {
		System.out.println("Start the test");
		testOn(userid);
	}

	@Override
	public void register() {

		System.out.println("Enter the User name");
		String name=scan.next();
		System.out.println("Enter the mail");
		String mail=scan.next();
		System.out.println("Enter the Password");
		String pswd=scan.next();

		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;

		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("quizProject");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			UserBean bean=new UserBean();

			bean.setUname(name);
			bean.setEmail(mail);
			bean.setPassword(pswd);

			entityManager.persist(bean);
			System.out.println("Candidate Registration Successfull");
			transaction.commit();
		}catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			try {
				if(entityManagerFactory!=null) {
					entityManagerFactory.close();
				}if(entityManager !=null) {
					entityManager.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void java(int userid) {


		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;

		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("quizProject");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			UserBean bean=new UserBean();

			
			String sql="select * from QuestionsBean where topicId=1";

			Query query=entityManager.createQuery(sql);
			List<QuestionsBean> list =query.getResultList();
			int count=0;
			for (QuestionsBean questionsBean : list) {
				System.out.println(questionsBean.getQuestion());
				System.out.println("a. "+questionsBean.getOption1());
				System.out.println("b. "+questionsBean.getOption2());
				System.out.println("c. "+questionsBean.getOption3());
				System.out.println("d. "+questionsBean.getOption4());
				System.out.println("Enter your option(a/b/c/d) ");
				String choice=scan.next();
				if(choice.equals(questionsBean.getAnswer())) {
					count++;
				}
			}
			UserBean bean1=new UserBean();
			bean1.setUserid(userid);
			
			
			TopicsBean bean2=new TopicsBean();
			bean2.setTopicId(1);
			
			ResultsBean results=new ResultsBean();
			results.setUserBean(bean1);
			results.setQuizTopic(bean2);
			results.setResult(count);
		
			entityManager.persist(results);
			transaction.commit();
		}catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			try {
				if(entityManagerFactory!=null) {
					entityManagerFactory.close();
				}if(entityManager !=null) {
					entityManager.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}



	@Override
	public void html(int userid) {
		// TODO Auto-generated method stub

	}



	@Override
	public void sql(int userid) {
		// TODO Auto-generated method stub

	}

}
