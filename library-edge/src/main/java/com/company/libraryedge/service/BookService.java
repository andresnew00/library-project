package com.company.libraryedge.service;

import com.company.libraryedge.controller.EntityNotFoundException;
import com.company.libraryedge.model.Book;
import com.company.libraryedge.util.feign.BookClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookClient client;


    public List<Book> getAllBooks() {
        return client.getAllBooks();
    }





    public List<Book> checkOutBooksByIsbn(String isbn, String day) throws EntityNotFoundException {

        List<Book> bList = client.getAllBooks();
//        Boolean ifExists = bList.stream().anyMatch(book -> isbn(book.getIsbn()));
//        bList.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().isPresent();


        if (bList.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().isPresent()) {
            if (day.equals("Monday")||day.equals("Wednesday")||day.equals("Friday")) {
                return client.getAllBooks().subList(0, 3);
            } else if (day.equals("Tuesday")||day.equals("Thursday")) {
                return client.getAllBooks().subList(0, 2);
            } else if (day.equals("Saturday")) {
                return client.getAllBooks().subList(0, 4);
            } else if (day.equals("Sunday")) {
                return client.getAllBooks().subList(0, 1);
            }




        } else {
            throw new EntityNotFoundException("We could not find any books matching that isbn");
        }
        return null;
    }

}
