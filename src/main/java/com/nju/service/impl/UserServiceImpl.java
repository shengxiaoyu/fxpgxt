package com.nju.service.impl;


import com.nju.data.dao.UserDODAO;
import com.nju.data.dataobject.UserDO;
import com.nju.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDODAO userDao ;

    @Override
    public String getUserPass(String username) {
    	List<UserDO> users =userDao.findByName(username) ;
    	if(users !=null && !users.isEmpty()){
    		return users.get(0).getPassword() ;
    	}
    	return null ;
    }

	@Override
	public List getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll() ;
	}

	@Override
	public UserDO getUserByName(String name) {
		// TODO Auto-generated method stub
		List users =userDao.findByName(name);
		if(users!=null && !users.isEmpty()){
			return (UserDO) users.get(0) ;
		}
		return null ;
	}

	@Override
	public boolean register(UserDO user) {
		// TODO Auto-generated method stub
		int id = userDao.getMaxId() ;
		user.setId(id) ;
		userDao.save(user) ;
		return true ;
	}
    
}
