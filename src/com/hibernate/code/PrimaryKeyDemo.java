package com.hibernate.code;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			Student student1 = new Student("Rafael Nadal","Pereira","rafael_nadal@gmail.com");
			Student student2 = new Student("Harry","Kane","harry_kane@gmail.com");
			Student student3 = new Student("Kane","Williamson","kane_williamson@gmail.com");
			session.beginTransaction();
			//save  OBJECT --- INTO DB
			session.save(student1);
			session.save(student2);
			session.save(student3);
			//RETRIEVE FROM DB
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student temp = session.get(Student.class,2);
			System.out.println("Details : "+ temp.getEmail()+" "+temp.getFirstName()+" "+temp.getLastName());
			session.getTransaction().commit();
			//QUERY RETRIEVAL
			session = factory.getCurrentSession();
			session.beginTransaction();
			//hib 5.2 >: getResultList();
			List<Student> studentlist = session.createQuery("from Student").getResultList();
			for(Student obj : studentlist)
			{
				System.out.println("FROM DB -- "+ obj.getEmail()+" "+ obj.getFirstName()+" "+obj.getLastName());
			}
			//UPDATE:
			int result = session.createQuery("update Student set last_name = 'Pererra' where id = 1")
					.executeUpdate();
			System.out.println("update result : "+ result);
			//DELETE
			int del_result = session.createQuery("delete from Student where id = 2").executeUpdate();
			System.out.println("delete result: "+ del_result);
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
