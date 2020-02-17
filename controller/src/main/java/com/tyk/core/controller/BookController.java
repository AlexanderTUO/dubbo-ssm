package com.tyk.core.controller;

import com.tyk.core.bean.Book;
import com.tyk.core.service.BookService;
import com.tyk.core.sys.bean.User;
import com.tyk.core.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @RequestMapping("/testDubbo")
    public String findById(Model model) {
        Book book = bookService.findById("1000");
        User user = userService.findByUserName("admin");
        model.addAttribute(book);
        return "testDubbo";
    }
}
