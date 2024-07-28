package com.flight.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.bean.User;
import com.flight.dao.InvalidUserException;
import com.flight.dao.UserDao;


@Service
public class UserBo {
	@Autowired
	UserDao uDao;
	
	public boolean validateUser(User u) throws InvalidUserException {
		
		var user = uDao.getUser(u);
		if(user!=null && user.getPassword().equals(u.getPassword())) {
			return true;
		}else {
			System.out.println(" dbiuds");
			return false;
		}
			
		
	}
	
}
