package com.uas.ui;

import java.util.Scanner;

import com.uas.beans.Application;
import com.uas.beans.Login;
import com.uas.beans.Program;
import com.uas.dao.ApplicationDAO;
import com.uas.dao.ApplicationDAOImpl;
import com.uas.service.AdminService;
import com.uas.service.AdminServiceImpl;
import com.uas.service.LoginService;
import com.uas.service.LoginServiceImpl;
import com.uas.service.MACservice;
import com.uas.service.MACserviceImpl;

public class LoginUI {
	 void getLogin()
		{
		String user,pass,role;
		Application app = new Application();
		MACservice mac = new MACserviceImpl();
		ApplicationDAO applicant = new ApplicationDAOImpl();
		Program prg =new Program();
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter valid username");
		user =sc.next();
		System.out.println("Enter valid password");
		pass=sc.next();
		Login l =new Login(user,pass);
		LoginService obj = new LoginServiceImpl();
		role =obj.authenticate(user,pass);
		System.out.println(role);
		if(role.equals("MAC"))
		{
			
			System.out.println("MAC");
			mac.showDetails();
			String ch;
			do
			{
			System.out.println("Enter 1 for updating the status of candidate and setting up an interview date. ");
			System.out.println("Enter 2 for confirming or rejecting the application");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
			{
				System.out.println("select id");
				int idd= sc.nextInt();
				String status = mac.showStatus(idd);
				System.out.println(status);
				if(status.equals("applied")) {
					System.out.println("Enter 1 to accept the candidate:");
					System.out.println("Enter 2 to reject the candidate:");
					int choice1 = sc.nextInt();
					if(choice1==1)
					{
					mac.updateStatus(idd, "accepted");
					status = "accepted";
					
					System.out.println("show updated table.................");
					mac.showDetails();
					
					}
					if(choice1==2)
					{
					mac.updateStatus(idd, "rejected");
					status = "rejected";
					System.out.println("show updated table.................");
					mac.showDetails();
					
					}
				}
				if(status.equals("accepted")) {
					System.out.println("Status of the candidate is already 'accepted', waiting for confirmation");
					System.out.println("show updated table.................");
					mac.showDetails();
				
				}
				if(status.equals("confirmed")) {
					System.out.println("Status of the candidate can not be changed.");
					System.out.println("show updated table.................");
					mac.showDetails();
				
				}
				
			
				break;
			}
			case 2:
			{
				System.out.println("select id");
				int idd= sc.nextInt();
				String status = mac.showStatus(idd);
				if(status.equals("applied")) {
					System.out.println("Status of the candidate can not be changed directly to confirmation without interview");
					System.out.println("show updated table.................");
					mac.showDetails();
					
				}
				if(status.equals("accepted")) {
					System.out.println("Enter 1 to confirm the candidate:");
					System.out.println("Enter 2 to reject the candidate:");
					int choice1 = sc.nextInt();
					if(choice1==1)
					{
					mac.confirmationStatus(idd, "confirmed");
					status = "confirmed";
					System.out.println("show updated table.................");
					mac.showDetails();
					
					}
					if(choice1==2)
					{
					mac.confirmationStatus(idd, "rejected");
					status = "rejected";
					System.out.println("show updated table.................");
					mac.showDetails();
				
					}
				}
				if(status.equals("confirmed")) {
					System.out.println("Status of the candidate can not be changed.");
					System.out.println("show updated table.................");
					mac.showDetails();
				
				}
				break;
			}
		}
			System.out.println("Do You Want To Continue");
			ch=sc.next();
			}while(ch.equals("y"));
		}
		if(role.equals("ADMIN"))
		{
			
			AdminService service =new AdminServiceImpl();
			int choice1 = 0;
			String p=null;
			
			System.out.println("Enter the operation you want to perform");
			System.out.println("1.List of Programs Offered");
			System.out.println("2.List of Applicant Details");
			System.out.println("3.Add Program");
			System.out.println("4.Delete Program");
			choice1 = sc.nextInt();
			switch(choice1)
			{
			case 1:
			{
				System.out.println("--------List of Available Programs---------\n");
				System.out.println(applicant.showDetails());
				break;
			}
			case 2:
			{
				System.out.println("--------List of Applicants---------\n");
				mac.showDetails();
				break;
			}
			case 3:
			{
				System.out.println("--------New Program Form---------\n");
				System.out.println("Enter program name: ");
				prg.setProgram(sc.next());
				System.out.println("Enter program description: ");
				prg.setDescription(sc.next());		//BufferedReade)r
				System.out.println("Enter candidate eligibility: ");
				prg.setEligibility(sc.next());
				System.out.println("Enter program duration: ");
				prg.setDuration(sc.nextInt());
				System.out.println("Enter degree type: ");
				prg.setDegree(sc.next());
				
				service.addDetails(prg);	
				break;
				
			}
			case 4:
			{
				System.out.println("--------Delete Program---------\n");
				System.out.println("--------List of Programs-------");
				System.out.println(applicant.showDetails());
				System.out.println();
				System.out.println("Enter the program to be deleted: ");
				p = sc.next();
				service.deleteDetails(p);
				break;
			}
			}
		}
		}
		}


