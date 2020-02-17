package com.tyk.core.config;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Test {
    public static void main(String[] args) {
        String password = "123456";
        String salt = "tyk";
        Integer hashIterations = 1024;

        Md5Hash md5Hash = new Md5Hash(password, salt, hashIterations);
        System.out.println(md5Hash.toString());
    }
}
