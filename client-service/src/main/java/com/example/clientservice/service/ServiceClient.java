package com.example.clientservice.service;

import com.example.clientservice.model.Book;

import java.util.List;

public interface ServiceClient {
    public List<Book> getAllBookByFeignClient();
    public List<Book> getAlllBooksByWebClient();
}
