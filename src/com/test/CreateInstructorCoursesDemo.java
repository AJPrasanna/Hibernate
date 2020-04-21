package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.Course;
import com.test.Instructor;
import com.test.InstructorDetail;
import com.test.Review;

public class CreateInstructorCoursesDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			// create instructor
			Instructor tempInstructor = new Instructor("Daffy", "Duck", "daffy.duck@luv2code.com");
			
			session.save(tempInstructor);
			
			// create some courses
			Course tempCourse1 = new Course("Duck training - volume 1");
			Course tempCourse2 = new Course("Duck training - volume 2");
			
			// add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





