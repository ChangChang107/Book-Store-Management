package com.tutorialProject.bookStoreManagement.controller;


import com.tutorialProject.bookStoreManagement.entity.Book;
import com.tutorialProject.bookStoreManagement.entity.MyBookList;
import com.tutorialProject.bookStoreManagement.service.BookService;
import com.tutorialProject.bookStoreManagement.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookService myBookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book> list = service.getAllBook();
//        ModelAndView m = new ModelAndView();
//        m.setViewName("bookList");
//        m.addObjects("book", list)
        return new  ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public ModelAndView getMyBooks() {
        List<MyBookList> myBooks = myBookService.getMyBooks();
        return new ModelAndView("myBooks", "book", myBooks);
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book book = service.getBookById(id);
        MyBookList myBook = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        myBookService.saveMyBook(myBook);
        return "redirect:/my_books";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteBook(id);
        return "redirect:/available_books";
    }
}
