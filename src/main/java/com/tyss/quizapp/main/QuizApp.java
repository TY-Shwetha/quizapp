package com.tyss.quizapp.main;

import java.util.Scanner;

import com.tyss.quizapp.service.QuizService;
import com.tyss.quizapp.service.QuizServiceImpl;

public class QuizApp {
	
	public static void calling() {
		
		QuizService gmail=new QuizServiceImpl();
		
		while(true) {
			Scanner scan=new Scanner(System.in);		
			System.out.println("Press 1 to login ");
			System.out.println("Press 2 to register ");
			System.out.println("Press 3 to exit");
			int input=scan.nextInt();

			switch(input) {
			case 1:
				gmail.login();
				break;

			case 2:
				gmail.register();
				break;

			case 3:
			System.exit(0);
			break;
			}			
		}		
	}
	public static void main(String[] args) {
		calling();
	}
}
