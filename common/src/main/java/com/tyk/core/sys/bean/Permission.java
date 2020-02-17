package com.tyk.core.sys.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission  implements Serializable {
    private String pid;
    private String url;
}
