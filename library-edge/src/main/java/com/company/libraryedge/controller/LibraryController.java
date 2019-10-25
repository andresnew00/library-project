package com.company.libraryedge.controller;

import com.company.libraryedge.model.Book;
import com.company.libraryedge.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class LibraryController {

    @Autowired
    BookService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> checkOutAllBooks



}
