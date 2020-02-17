package com.tyk.core.dao;

import com.tyk.core.bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao {
    public Book findById(String Id);
}
