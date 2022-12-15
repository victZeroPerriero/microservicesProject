package com.example.clientservice.service;

import com.example.clientservice.listconst.ListUrl;
import com.example.clientservice.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceClientImpl implements ServiceClient {
    private final WebClient webClient;
    private final ServiceBConnector serviceBConnector;
    @Override
    public List<Book> getAllBookByFeignClient() {
        return serviceBConnector.getAllBooks();
    }

    @Override
    public List<Book> getAlllBooksByWebClient() {
        log.info("get all books from remote book service {}", getAllBook().buffer().blockFirst());
        return getAllBook().buffer().blockFirst();
    }
    private Flux<Book> getAllBook(){
       return webClient.get().uri(ListUrl.URL_WEB_CLIENT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(Book.class);
    }
}
