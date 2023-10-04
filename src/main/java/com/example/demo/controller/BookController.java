package com.example.demo.controller;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void insertBook(@RequestBody BookRequest bookRequest) {
        bookService.insertBook(bookRequest);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<BookResponse> findAllBooks(@PathVariable(name = "bookId") Long id) {
        return ResponseEntity.ok(bookService.findBook(id));
    }
}
