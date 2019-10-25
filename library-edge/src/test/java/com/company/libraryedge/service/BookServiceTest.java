package com.company.libraryedge.service;

import com.company.libraryedge.controller.EntityNotFoundException;
import com.company.libraryedge.model.Book;
import com.company.libraryedge.util.feign.BookClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @InjectMocks
    BookService service;

    @Mock
    BookClient client;

    @Before
    public void setUp() throws Exception {
        setUpBookClientMock();
    }

    public void setUpBookClientMock() {
        Book in = new Book(null, "isbn", "title", "author");

        Book out = new Book(1, "isbn", "title", "author");

        List<Book> bookList = new ArrayList<>();
        bookList.add(out);

        doReturn(bookList).when(client).getAllBooks();

    }

    @Test
    public void getAllBooks() {
        Book out = new Book(1, "isbn", "title", "author");

        List<Book> expected =  service.getAllBooks();

        assertEquals(1, expected.size());
    }

    @Test
    public void checkOutBooksByIsbnOnMonday() throws EntityNotFoundException {
        Book one = new Book(1, "isbn", "title", "author");
        Book two = new Book(1, "isbn", "title", "author");
        Book three = new Book(1, "isbn", "title", "author");
        Book four = new Book(1, "isbn", "title", "author");
        Book five = new Book(1, "isbn", "title", "author");

        List<Book> expected = new ArrayList<>();
        expected.add(one);
        expected.add(two);
        expected.add(three);


        // Act
        List<Book> myBooks =  service.getAllBooks();
        List<Book> expectedBooks = service.checkOutBooksByIsbn("isbn", "Monday");

        when(service.checkOutBooksByIsbn("isbn", "Monday")).thenReturn(expected);

        assertEquals(3, expected.size());
        assertEquals(3, expectedBooks.size());


    }
}