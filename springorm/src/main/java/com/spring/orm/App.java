package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
       StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//       Student student = new Student(133,"adnan"," tx-devon");
//       int r = studentDao.insert(student);
//       System.out.println(r);
       System.out.println("-----welcome------");
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       boolean go   = true;
      while(go) { 
    	  
       System.out.println("press 1 to add new student");
//       System.out.println("press 2 to display all students");
       System.out.println("press 2 t0 get detail of single student");
       System.out.println("press 3 t0 delete student data");
       System.out.println("press 4 to update");
       System.out.println("press 5 to exit");
       
      
       try {
		int input = Integer.parseInt(br.readLine());
		switch(input) {
		
		case 1: 
			// add
			// talking input from user
			System.out.println("enter user id");
			int uid = Integer.parseInt(br.readLine());
			System.out.println("enter name");
			String uname= br.readLine();
			System.out.println("enter city");
			String ucity = br.readLine();
			// creating a object
			Student s = new Student();
			s.setStudentId(uid);
			s.setStudentName(uname);
			s.setStudentCity(ucity);
			// saving student object to database
			int r = studentDao.insert(s);
			System.out.println(r);
			System.out.println("-------------------");
			break;
		
		case 2:
//			get single student
			System.out.println("enter user userid");
			int userid = Integer.parseInt(br.readLine());
			Student student = studentDao.getStudent(userid);
			
			System.out.println("id = "+student.getStudentId());
			System.out.println("name="+student.getStudentName());
			System.out.println("city="+student.getStudentCity());
			
			break;
		
		case 3:
//			delete
			System.out.println("enter user userid");
			int id = Integer.parseInt(br.readLine());
			studentDao.deletestudent(id);
			 System.out.println("deleted successfully");
			
			break;
		case 4:
//			update
			System.out.println("enter user userid");
			int urid = Integer.parseInt(br.readLine());
			System.out.println("enter name");
			String urname= br.readLine();
			System.out.println("enter city");
			String urcity = br.readLine();
			Student st = new Student();
			st.setStudentId(urid);
			st.setStudentName(urname);
			st.setStudentCity(urcity);
//			int rs = studentDao.updateStudent(st);
//			System.out.println(rs);
			System.out.println("-------------------");
			
			

			break;
		
		case 5:
//			exit
			go = false;
			break;
		
		}
	} 
        
       catch (Exception e) {
		System.out.println("please enter a valid input option");
		System.out.println(e.getMessage());
	}
        
    }

    System.out.println("thank you");
    }
}






    
