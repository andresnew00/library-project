package com.company.libraryCrudservice.dao;

import com.company.libraryCrudservice.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository repo;

    Book book1, book2;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();

        book1 = new Book(
                null,"12345","title","author"
        );

        book2 = new Book(
                null,"23456","title2","author2"
        );
    }

    @Test
    public void createBook(){
        repo.save(book1);

        assertEquals(1,repo.findAll().size());
    }

    @Test
    public void getAllBooks() {
        repo.save(book1);
        repo.save(book2);

        List<Book> books = new ArrayList<>();
        books.add(book2);
        books.add(book1);

        assertEquals(books.size(), repo.findAll().size());
    }

    @Test
    public void getById(){
        repo.save(book1);

        Book bookActual = repo.findById(book1.getId()).orElse(null);

        assertEquals(book1,bookActual);
    }

    @Test
    public void updateBook(){
        repo.save(book1);
        book1.setAuthor("No author");
        repo.save(book1);

        Book bookActual = repo.findById(book1.getId()).orElse(null);

        assertEquals(book1,bookActual);
    }

    @Test
    public void deleteBook(){
        repo.save(book1);

        repo.deleteById(book1.getId());

        assertNull(repo.findById(book1.getId()).orElse(null));
    }

}