package com.student;
import java.util.Scanner;

import com.student.dao.StudentDAO;
public class Main {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n=====STUDENT MANAGEMENT SYSTEM=====");
			
			System.out.println("1.Add Student");
			System.out.println("2.View Student");
			System.out.println("3.Search Student");
			System.out.println("4.Update Student");
			System.out.println("5.Delete Student");
			
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1 :
				System.out.println("Enter ID: ");
			    int id=sc.nextInt();
		    	sc.nextLine();
			
		    	System.out.println("Enter Name: ");
		    	String name = sc.nextLine();
		    	
		    	System.out.println("Enter Email: ");
		    	String email = sc.nextLine();
		    	
		    	System.out.println("Enter Course: ");
		    	String course = sc.nextLine();
		    	
		    	System.out.println("Enter Age: ");
		    	int age = sc.nextInt();
		    	sc.nextLine();
		    	
		    	dao.addStudent(id, name, email, course, id);
		    	break;
		    	
			case 2 : 
				
				dao.viewStudents();
				break;
				
			case 3 :
				System.out.println("Enter Student ID: ");
		    	int searchId = sc.nextInt();
		    	
		    	dao.searchStudents(searchId);
		    	break;
		    	
			case 4:
				System.out.println("Enter Student ID: ");
			    int updatedId=sc.nextInt();
		    	sc.nextLine();
			
		    	System.out.println("Enter New Name: ");
		    	String newName = sc.nextLine();
		    	
		    	System.out.println("Enter New Email: ");
		    	String newEmail = sc.nextLine();
		    	
		    	System.out.println("Enter New Course: ");
		    	String newCourse = sc.nextLine();
		    	
		    	System.out.println("Enter New Age: ");
		    	int newAge = sc.nextInt();
		    	sc.nextLine();
		    	
		    	dao.updateStudent(updatedId, newName, newEmail, newCourse, newAge);
		    	break;
		    	
			case 5:
				System.out.println("Enter ID to Delete: ");
				int deleteId = sc.nextInt();
				sc.nextLine();
				
				dao.deleteStudent(deleteId);
				break;
				
			case 6:
				System.out.println("Thank you");
				sc.close();
				return;
				
			default:
				System.out.println("Invalid choice");
				
			}
			
			
		}
	

	}

}
