package com.GreatLearning.SurabiAssignment3.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GreatLearning.SurabiAssignment3.dao.AdminDAO;
import com.GreatLearning.SurabiAssignment3.entity.Admin;
import com.GreatLearning.SurabiAssignment3.entity.Bills;
import com.GreatLearning.SurabiAssignment3.entity.Customer;
import com.GreatLearning.SurabiAssignment3.service.AdminService;
import com.GreatLearning.SurabiAssignment3.service.UserService;



@RestController
@RequestMapping("/surabi")

@CrossOrigin(origins={"http://localhost:3000","http://localhost:4200","*"})
public class AdminController {
	
	AdminService admin;
	
	@Autowired
	public AdminController(AdminService theadmin) {
		admin = theadmin;
	}
	
	@Autowired
	AdminDAO ad;
	
	@Autowired
	UserService user;
	
	
//	public AdminController(AdminService theadmin) {
//		admin = theadmin;
//	}
//	
	
	 @GetMapping("/admindata")
	 public List<Admin> data() {
		 return ad.data();
	 }

	 @PostMapping("/customer/create")
		public void create(@RequestBody Customer c) {
			System.out.println("hello mojonvdvid");
			String s= user.Createcus(c);
		}
		
//	
//	 @PostMapping("/admin/daymenu")
//	    public List<Bills>daybillsdisplay(@RequestBody Admin theadmin){
//	    	
//	    	return admin.dailyBill(theadmin);
//	    }
//	 
//	 @PostMapping("/admin/monthmenu")
//	    public List<Bills>monthsbillsdisplay(@RequestBody Admin theadmin){
//	    	
//	    	return admin.monthBill(theadmin);
//	    }
//	 
		
	 @GetMapping("/admin/daymenu")
	    public List<Bills>daybillsdisplay(){
	    	
	    	return ad.dailyBill();
	    }
	 
	 @GetMapping("/admin/monthmenu")
	    public List<Bills>monthsbillsdisplay(){
	    	
	    	return ad.monthBill();
	    }
	 
	 
	 
	 
	 
	 
	  @GetMapping("/admin/logout")
	    public String logoutfun1() {
	    	return "YOU HAVE LOGGED OUT";
	    }
	   
	  //crud operations on customer credentials
	  
//		@PostMapping("/admin/customer/create")
//		public String create(@RequestBody Customer c) {
//			return admin.Createcus(c);
//		}
        
	  @GetMapping("/admin/customer/show/{id}")
		public Customer Update(@PathVariable int id) {
			return admin.showcus(id);
		}
}
