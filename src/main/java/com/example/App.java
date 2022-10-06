package com.example;


import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        Student s=ac.getBean(Student.class);
        StudentDAO dao=ac.getBean(StudentDAO.class);
        Scanner sc=new Scanner(System.in);
        int choice;
        while(true) {
        	
        	System.out.println("Select the operation\n1.Insert\n2.Update\n3.Retrieve\n4.Delete");
        	System.out.println("Enter your choice: 1/2/3/4");
        	choice=sc.nextInt();
        	switch(choice) {
        
        	case 1:
        		
        		System.out.println("Enter the value of id");
                s.setId(sc.nextInt());
                System.out.println("Enter the value of name");
                s.setName(sc.next());
                System.out.println("Enter the value of email");
                s.setEmail(sc.next());
                int row=dao.insert(s);
                
                if(row>0) {
                	System.out.println("insertion is successful...");
                }
                else {
                	System.out.println("insertion failed....");
                }
                
                break;
        		
        	case 2:
        		  
            	  System.out.println("Enter ID of student to be updated= ");
        		  s.setId(sc.nextInt());
        		  System.out.println("Enter Name= ");
        		  s.setName(sc.next());
        		  System.out.println("Enter Email= ");
        		  s.setEmail(sc.next());
        		  int upd=dao.update(s);
        		  
        		  if(upd>0) {
                  	System.out.println("Updation is successful...");
                  }
                  else {
                  	System.out.println("Updation failed....");
                  }
        		  
        		  break;
        		  
        	case 3:
        		
        		  
                System.out.println("retrive from the table");
                List<Student> ss=dao.getallstudents();
                for(Student student:ss) {
                	System.out.println(student.getId()+"  "+student.getName()+"  "+student.getEmail());
                }

                  break;
        		
        	case 4:
        		
        		System.out.println("Enter ID of student to be deleted= ");
      		  s.setId(sc.nextInt());
      		 
      		  int del=dao.delete(s);
      		  
      		  if(del>0) {
                	System.out.println("Deleted successfully...");
                }
                else {
                	System.out.println("Deletion failed....");
                }
      		  
      		break;
        		
        		
        	default: System.out.println("Choose the correct option");	
        	      break;
        	}
        }
        
        
        
        
        
        
    }
}
