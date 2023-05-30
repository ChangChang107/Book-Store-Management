package com.tutorialProject.bookStoreManagement.service;

import com.tutorialProject.bookStoreManagement.entity.MyBookList;
import com.tutorialProject.bookStoreManagement.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {

    @Autowired
    private MyBookRepository myBooks;

    public void saveMyBook(MyBookList book) {
        myBooks.save(book);
    }

    public List<MyBookList> getMyBooks() {
         return myBooks.findAll();
    }

    public void deleteById(int id) {
        myBooks.deleteById(id);
    }


}
