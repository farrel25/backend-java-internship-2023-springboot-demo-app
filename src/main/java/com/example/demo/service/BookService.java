package com.example.demo.service;

import com.example.demo.dto.request.BookRequest;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void insertBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());

        bookRepository.save(book);
    }

    public List<BookResponse> findAllBooks() {
        List<Book> bookList = bookRepository.findAll();

        List<BookResponse> bookResponseList = new ArrayList<>();

        for (Book book : bookList) {
            BookResponse bookResponse = new BookResponse();
            bookResponse.setId(book.getId());
            bookResponse.setTitle(book.getTitle());

            bookResponseList.add(bookResponse);
        }

        return bookResponseList;
    }

    public BookResponse findBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        BookResponse bookResponse = new BookResponse();
        if (bookOptional.isPresent()) {
            bookResponse.setTitle(bookOptional.get().getTitle());
            bookResponse.setId(bookOptional.get().getId());
        } else {
            throw new RuntimeException();
        }

        return bookResponse;
    }
}
