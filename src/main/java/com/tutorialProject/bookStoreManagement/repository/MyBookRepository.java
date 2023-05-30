package com.tutorialProject.bookStoreManagement.repository;

import com.tutorialProject.bookStoreManagement.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {
}
