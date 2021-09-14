package com.GreatLearning.SurabiAssignment3.dao;

import java.util.List;

import com.GreatLearning.SurabiAssignment3.entity.Admin;
import com.GreatLearning.SurabiAssignment3.entity.Bills;
import com.GreatLearning.SurabiAssignment3.entity.Customer;

public interface AdminDAO {
	public boolean loginA(int id , String name , String password) ;
	public void logout() ;
	public List<Bills>dailyBill();
	public List<Bills>monthBill();
	public List<Admin>data();
	//crud
	public String Createcus(Customer c);
	public String deletecus(Customer c);
	public String Updatecus(Customer c);
	public Customer showcus(int id);
}
