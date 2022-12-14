package com.example.bookservice.service;

import com.example.bookservice.model.Book;
import com.example.bookservice.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        log.info("all books from repository {}", bookRepository.findAll());
        return bookRepository.findAll();
    }
}
