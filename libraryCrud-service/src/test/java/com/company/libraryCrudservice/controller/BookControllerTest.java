package com.company.libraryCrudservice.controller;

import com.company.libraryCrudservice.dao.BookRepository;
import com.company.libraryCrudservice.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @MockBean
    private BookRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    Book inputBook, outputBook;

    @Before
    public void setUp() throws Exception {
        reset(repo);

        inputBook = new Book(
                1,"12345","title","author"
        );

        outputBook = new Book(
                2,"12345","title","author"
        );
    }

    @Test
    public void createBook() throws Exception {
        String inputJsonBook = mapper.writeValueAsString(inputBook);

        String outputJsonBook = mapper.writeValueAsString(outputBook);

        when(repo.save(inputBook)).thenReturn(outputBook);

        this.mockMvc.perform(post("/book")
                .content(inputJsonBook)
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJsonBook));
    }

    @Test
    public void getAllBooks() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(new Book(3,"12345","title","author"));
        books.add(new Book(4,"123454","title","author2"));

        when(repo.findAll()).thenReturn(books);
        String expectedJson = mapper.writeValueAsString(books);

        mockMvc.perform(get("/book"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    public void getBookById() throws Exception {
        String outputJson = mapper.writeValueAsString(outputBook);

        when(repo.findById(1)).thenReturn(Optional.ofNullable(outputBook));

        this.mockMvc.perform(get("/book/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateBook() throws Exception {
        String inputJson = mapper.writeValueAsString(outputBook);

        this.mockMvc.perform(put("/book/1")
                .content(inputJson)
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteBook() throws Exception {
        this.mockMvc.perform(delete("/book/" + inputBook.getId()))
                .andDo(print()).andExpect(status().isNoContent())
                .andExpect(content().string(""));
    }
}