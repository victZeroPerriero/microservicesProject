package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class BooksController {
    private Environment environment;
    private final BookService bookService;

    @RequestMapping(path = "/")
    public String home() {
        log.info("Book-Service running at port: {}",  environment.getProperty("local.server.port"));
        return environment.getProperty("local.server.port");
    }

    @GetMapping(path = "/show")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "/allbooks")
    public List<Book> findAllBooks() {
        log.info("all books from mongodb {}", bookService.getAllBooks());
        return bookService.getAllBooks();
    }
}
