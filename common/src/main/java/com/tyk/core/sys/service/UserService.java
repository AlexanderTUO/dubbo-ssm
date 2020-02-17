package com.tyk.core.sys.service;

import com.tyk.core.sys.bean.User;

public interface UserService {
    User findByUserName(String username);
}
