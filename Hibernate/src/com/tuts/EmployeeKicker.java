package com.tuts;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tuts.entity.employee.EmployeeEntity;



public class EmployeeKicker {

	public static void main(String[] args) throws SQLException {

		SessionFactory sessionFactory  =  new Configuration().configure().
				addAnnotatedClass(EmployeeEntity.class).buildSessionFactory();
		Session  session =  sessionFactory.getCurrentSession();

		try {
			//EmployeeEntity employeeEntity  = new EmployeeEntity("Raj" , 1000 , "abc@gmail.com");
			//session.save(employeeEntity);

			//EmployeeEntity  getEmp =  session.get(EmployeeEntity.class, 100);
			//System.out.println(getEmp);

			//List<EmployeeEntity> empList =  session.createQuery("from EmployeeEntity").getResultList();
			//System.out.println(empList);

			//EmployeeEntity  getEmp =  session.get(EmployeeEntity.class, 100);
			//getEmp.setEmail("xyz@gmail.com");
			
			//EmployeeEntity  emp  =   session.get(EmployeeEntity.class,101);
			//session.delete(emp);
			//session.createQuery("delete  from  EmployeeEntity  where id = 101 ").executeUpdate();
			
			session.beginTransaction();


			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}



	}
}
