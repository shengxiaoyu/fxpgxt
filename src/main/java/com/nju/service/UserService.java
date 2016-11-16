package com.nju.service;

import java.util.List;

import com.nju.data.dataobject.UserDO;



public interface UserService {
    List<UserDO> getAllUsers();
    public String getUserPass(String id);
    public UserDO getUserByName(String name) ;
    public boolean register(UserDO user) ;
}
