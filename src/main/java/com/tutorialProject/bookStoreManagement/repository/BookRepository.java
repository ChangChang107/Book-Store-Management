package com.tutorialProject.bookStoreManagement.repository;

import com.tutorialProject.bookStoreManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
