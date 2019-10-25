package com.company.libraryedge.util.feign;

import com.company.libraryedge.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("book-service")
public interface BookClient {

    @GetMapping(value = "/book")
    List<Book> getAllBooks();

}
