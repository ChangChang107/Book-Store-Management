package com.tutorialProject.bookStoreManagement.service;

import com.tutorialProject.bookStoreManagement.entity.Book;
import com.tutorialProject.bookStoreManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bRepo;

    public void save(Book b) {
        bRepo.save(b);
    }
}
