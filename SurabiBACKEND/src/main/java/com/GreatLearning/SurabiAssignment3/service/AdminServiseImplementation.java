package com.GreatLearning.SurabiAssignment3.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GreatLearning.SurabiAssignment3.dao.AdminDAO;
import com.GreatLearning.SurabiAssignment3.entity.Admin;
import com.GreatLearning.SurabiAssignment3.entity.Bills;
import com.GreatLearning.SurabiAssignment3.entity.Customer;



@Service
public class AdminServiseImplementation implements AdminService{

	
	
	@Autowired
	AdminDAO admin;
	
	
	@Override
	public boolean loginA(int id, String name, String password) {
		// TODO Auto-generated method stub
		return admin.loginA(id, name, password);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bills> dailyBill(Admin ad) {
		// TODO Auto-generated method stub
		return admin.dailyBill();
	}

	@Override
	public List<Bills> monthBill(Admin ad) {
		// TODO Auto-generated method stub
		return admin.monthBill();
	}

	@Override
	public String Createcus(Customer c) {
		// TODO Auto-generated method stub
		return admin.Createcus(c);
	}

	@Override
	public String deletecus(Customer c) {
		// TODO Auto-generated method stub
		return admin.deletecus(c);
	}

	@Override
	public String Updatecus(Customer c) {
		// TODO Auto-generated method stub
		return admin.Updatecus(c);
	}

	@Override
	public Customer showcus(int id) {
		// TODO Auto-generated method stub
		return admin.showcus(id);
	}

}
