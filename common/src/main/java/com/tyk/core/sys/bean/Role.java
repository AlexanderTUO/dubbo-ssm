package com.tyk.core.sys.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class Role  implements Serializable {
    private String rid;
    private String roleName;
    private String description;
    private Set<Permission> permissions = new HashSet<>();
    private Set<User> users =  new HashSet<>();
}
