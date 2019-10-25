package com.company.libraryCrudservice.dao;

import com.company.libraryCrudservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
