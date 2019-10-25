package com.company.libraryCrudservice.controller;

import com.company.libraryCrudservice.dao.BookRepository;
import com.company.libraryCrudservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository repo;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book createBook(Book book){
        return repo.save(book);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getAllBooks(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBookById(int id){
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateBook(@RequestBody @Valid Book book,@PathVariable int id){
        book.setId(id);
        repo.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(int id){
        repo.deleteById(id);
    }
}
