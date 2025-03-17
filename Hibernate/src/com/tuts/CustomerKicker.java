package com.tuts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tuts.entity.customer.Customer;
import com.tuts.entity.customer.CustomerDetail;
import com.tuts.entity.project.Project;

public class CustomerKicker {

	public static void main(String[] args) {

		SessionFactory  sessionFactory  =   new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(CustomerDetail.class).addAnnotatedClass(Project.class).buildSessionFactory();

		Session  session  =  sessionFactory.getCurrentSession();

		try{
			//			Customer  customer  =  new Customer("Raj", "Mohan", "abc@gmail.com");
			//			CustomerDetail  customerDetail  =  new CustomerDetail("Manger", "Thinking");
			//			customer.setCustomerDetailId(customerDetail);
			//			session.save(customer);


			//			Customer  customer  =  session.get(Customer.class, 2);
			//			session.delete(customer);


			/**bi directional **/
			//			CustomerDetail customerDetail  =  session.get(CustomerDetail.class, 2);
			//			System.out.println(customerDetail.getCustomer().getName());
			//			session.delete(customerDetail);
			
			
			session.beginTransaction();
			
			Customer  customer = session.get(Customer.class, 3);
			Project  project  =  new Project("AC");
			Project  project1  =  new Project("SCM");
			customer.add(project);
			customer.add(project1);
			
			session.save(project);
			session.save(project1);
			
			
			
			
			
			
			
			





			session.getTransaction().commit();


		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}
