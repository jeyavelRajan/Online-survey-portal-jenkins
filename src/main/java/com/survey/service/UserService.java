package com.survey.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.survey.bean.Login;
import com.survey.bean.Users;
import com.survey.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;
	
	Login login;
	
	public boolean registerUser(Users user) {
		user.setUserType("User");
		repo.save(user);
		return true;
	}
	
	public boolean UpdateUser(Users user) {
		user.setUserType("User");
		repo.save(user);
		return true;
	}
	
	public Login login(Users user) {
		Users uName=repo.getByUserName(user.getUserName());
		Users pass=repo.getByPassword(user.getPassword());
		if(uName!=null && pass!=null) {
			String value=uName.getPassword();
			String confirmPass=pass.getPassword();
			if (value.equals(confirmPass)) {
				String uType = uName.getUserType();
				if(uType.equalsIgnoreCase("Admin")) {
					return new Login("Admin Login Successfully");
				}else{
					return new Login("User Login Successfully");
				}
			}
			else {
				return new Login("Login Fail");
			}
		}  else {
		return new Login("Login Fail");
		}
		
	}	

	
	public boolean deleteUser(Long userId) throws Exception {
		repo.deleteById(userId);
		return true;
	}
	
	public List<Users> getAllUsers() {
		Iterator<Users> it =  repo.findAll().iterator();
		List<Users> list = new ArrayList<Users>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}

	public Users getUserById(Long userId) throws Exception {
		Users user = repo.findById(userId).get();
		return user;
	}
	
	public List<Users> getAllCandidates(){
		Iterator<Users> it =  repo.getAllCandidates().iterator();
		List<Users> list = new ArrayList<Users>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}
}

