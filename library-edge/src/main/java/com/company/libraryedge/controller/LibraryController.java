package com.company.libraryedge.controller;

import com.company.libraryedge.model.Book;
import com.company.libraryedge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class LibraryController {

    @Autowired
    BookService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping(value = "/isbn/{isbn}/{day}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooksByIsbn(@PathVariable Integer isbn, @PathVariable String day) {
        return null;
    }



}
