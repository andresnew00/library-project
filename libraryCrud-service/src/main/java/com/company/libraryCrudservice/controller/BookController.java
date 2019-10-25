package com.company.libraryCrudservice.controller;

import com.company.libraryCrudservice.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @PostMapping
    public Book createBook(Book book){
        return null;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return null;
    }

    @GetMapping("/{id}")
    public Book getBookById(int id){
        return null;
    }

    @PutMapping("/{id}")
    public void updateBook(int id){

    }

    @DeleteMapping("/{id}")
    public void deleteBook(int id){
        
    }
}
