package com.hibernate.code;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.code.Instructor;
import com.hibernate.code.InstructorDetail;

public class GetInstructorAndCourses {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			int id = 1;
			
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println(instructor);
			System.out.println(instructor.getCourseList());
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
			
		}
	}

}





