package com.GreatLearning.SurabiAssignment3.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.GreatLearning.SurabiAssignment3.entity.Admin;
import com.GreatLearning.SurabiAssignment3.entity.Bills;
import com.GreatLearning.SurabiAssignment3.entity.Customer;
import com.GreatLearning.SurabiAssignment3.entity.FoodMenu;


@Repository
public class AdminDAOimplementation implements AdminDAO {
	
	
    private EntityManager entityManager;
	
	@Autowired
	public AdminDAOimplementation(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	

	@Override
	public boolean loginA(int id, String name, String password) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Admin theadmin=currentSession.get(Admin.class,id);

        if(theadmin.getId()==id && theadmin.getName().equals(name) && theadmin.getPassword().equals(password)) {
			
			return true ;
		}
		return false;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bills> dailyBill() {
		// TODO Auto-generated method stub
//		boolean isValiduser = loginA(ad.getId(),ad.getName(),ad.getPassword());
//		System.out.println(isValiduser);
		if(true) {
			Session currentSession = entityManager.unwrap(Session.class);
			String daydate= java.time.LocalDate.now().toString();
			String hql = "from Bills where date = '"+daydate+"'";
			Query query = currentSession.createQuery(hql);
			//query.setString("price","");
			List results = query.list();
			return results;
		}
		return null;
	}

	@Override
	public List<Bills> monthBill(){
		// TODO Auto-generated method stub
//		boolean isValiduser = loginA(ad.getId(),ad.getName(),ad.getPassword());
//		System.out.println(isValiduser);
		if(true) {
			Session currentSession = entityManager.unwrap(Session.class);
			
			int month=java.time.LocalDate.now().getMonthValue();
			
			
			String hql = "from Bills where MONTH(date) = "+month+"";
			Query query = currentSession.createQuery(hql);
			//query.setString("price","");
			List results = query.list();
			return results;
		}
		return null;
		
	}



	@Override
	public String Createcus(Customer c) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(c);
		return "User is saved check the database";
	}



	@Override
	public String deletecus(Customer c) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		int id=c.getId();
		Query theQuery = currentSession.createQuery("delete from customer where userId = "+id+"");
		//theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		return "the user data with id ="+id+" is deleted";
	}



	@Override
	public String Updatecus(Customer c) {
		// TODO Auto-generated method stub
		String s=deletecus(c);
		String s1=Createcus(c);
		
		return "The user data is updated check the database";
	}



	@Override
	public Customer showcus(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer theUser = currentSession.get(Customer.class,id);
		return theUser;
	}



	@Override
	public List<Admin> data() {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from Admin";
		Query query = currentSession.createQuery(hql);
		//query.setString("price","");
		List results = query.list();
		return results;
	}

}
