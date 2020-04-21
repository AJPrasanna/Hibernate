package com.hibernate.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			Student student = new Student("Harry","Potter","harry_j_potter@gmail.com");
			student.setId(1);
			/*
			 * student.setFirstName("Harry"); 
			 * student.setLastName("Potter");
			 * student.setEmail("harry_j_potter@gmail.com");
			 */
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			factory.close();
		}

	}

}
