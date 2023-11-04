package com.spring.orm.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

import antlr.collections. List ;

public class StudentDao {

  
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	private HibernateTemplate hibernateTemplate; 
	// to insert a value we need to use hibernate template 
	  @Transactional
	  // to save the data
	public int insert(Student student) {
	Integer i =(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	// get the single data
	  public Student getStudent(int studentId) {
	Student student =this.hibernateTemplate.get(Student.class,studentId);
	return student;
	  }
	  
//	  get multiple data
//	  public void  List<Student>getAllStudents(){
//		  List<Student> sudents = this.hibernateTemplate.loadAll(Student.class);
//		  return sudents;	  
//	  }
		
	  
//	  delete
	  @Transactional
	  public void deletestudent(int studentId) {
	Student student =this.hibernateTemplate.get(Student.class,studentId);	  
	  }
//	  update 
	  @Transactional
	  public void updateStudent(Student student) {
		  this.hibernateTemplate.update(student);
	  }
}
