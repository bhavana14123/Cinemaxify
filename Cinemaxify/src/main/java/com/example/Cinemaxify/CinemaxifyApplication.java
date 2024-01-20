package com.example.Cinemaxify;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class CinemaxifyApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Cinemaxify Application");
		while (true) {
			System.out.println("Please select the member you want the plan for:");
			System.out.println("1. Self\n2. Spouse");
			String userType = "";
			int userChoice = scanner.nextInt();
			scanner.nextLine();
			switch (userChoice) {
				case 1 -> userType = "self";
				case 2 -> userType = "spouse";
				case 3 -> {
					System.out.println("Exiting...");
					return;
				}
				default -> {
					System.out.println("Invalid choice.");
					return;
				}
			}

			System.out.println("Please select your plan: \n1. Normal \n2.Premium");
			int planChoice = scanner.nextInt();
			scanner.nextLine();
			String myPlan = "";
			switch (planChoice) {
				case 1 -> {
					// b. Set myPlan according to the planChoice.
					myPlan="Normal";
				}
				case 2 ->{
					// c. Set myPlan according to the planChoice.
					myPlan="Premium";
				}
				default -> {
					// d. Print "invalid choice" and return.
					System.out.println("invalid choice");
					return;
				}
			}


			User user = (User)context.getBean(userType+myPlan);
			System.out.println("Please enter your name:");
			String name=scanner.nextLine();
			System.out.println("Please enter your age:");
			int age=scanner.nextInt();
			System.out.println("Please enter your contact:");
			Long contact= scanner.nextLong();
			scanner.nextLine();
			System.out.println("Please enter your address:");
			String address= scanner.nextLine();
			user.setUserDetails(name,age,contact,address);
			user.getUserDetails();

			System.out.println("Do you want to purchase plan for someone else \n1. Yes \n2. No");



			int input = scanner.nextInt();
			if (input == 2) break;
		}

	}

}
