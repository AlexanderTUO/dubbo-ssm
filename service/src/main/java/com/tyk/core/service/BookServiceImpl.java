package com.tyk.core.service;

import com.tyk.core.bean.Book;
import com.tyk.core.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Book findById(String Id) {
        return bookDao.findById(Id);
    }
}
