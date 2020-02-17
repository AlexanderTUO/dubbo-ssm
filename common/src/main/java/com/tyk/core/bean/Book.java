package com.tyk.core.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    String bookId;
    String bookName;
    Integer number;
}
