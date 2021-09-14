package com.GreatLearning.SurabiAssignment3.service;

import java.util.List;

import com.GreatLearning.SurabiAssignment3.entity.Admin;
import com.GreatLearning.SurabiAssignment3.entity.Bills;
import com.GreatLearning.SurabiAssignment3.entity.Customer;

public interface AdminService {
	public boolean loginA(int id , String name , String password) ;
	public void logout() ;
	public List<Bills>dailyBill(Admin ad);
	public List<Bills>monthBill(Admin ad);
	
	public String Createcus(Customer c);
	public String deletecus(Customer c);
	public String Updatecus(Customer c);
	public Customer showcus(int id);
}
