package com.example.clientservice.controller;

import com.example.clientservice.model.Book;
import com.example.clientservice.service.ServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ClientController {
    private final ServiceClient serviceClient;
   @GetMapping(path = "/getAllBooksByFeignClient")
    public List<Book> getAllBookByFeignClient(){
        return serviceClient.getAllBookByFeignClient();
    }
   @GetMapping(path = "/getAllBooksByWebClient")
    public List<Book> getAlllBooksByWebClient() {
        return serviceClient.getAlllBooksByWebClient();
    }
}
