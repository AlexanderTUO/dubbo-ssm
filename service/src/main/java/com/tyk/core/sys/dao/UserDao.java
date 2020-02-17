package com.tyk.core.sys.dao;

import com.tyk.core.sys.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User findByUserName(String username);
}
