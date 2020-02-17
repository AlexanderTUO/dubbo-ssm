package com.tyk.core.sys.service;

import com.tyk.core.sys.bean.User;
import com.tyk.core.sys.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }
}
