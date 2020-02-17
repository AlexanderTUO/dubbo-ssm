package com.tyk.core.sys.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class User implements Serializable {
    private String uid;
    private String userName;
    private String password;
    private String salt;
    private Set<Role> roles = new HashSet<>();
}
