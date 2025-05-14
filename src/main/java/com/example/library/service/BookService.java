package com.example.library.service;

import com.example.library.model.Books;
import com.example.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepository;

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Books> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public Books addBook(Books book) {
        return bookRepository.save(book);
    }

    public Books updateBook(String id, Books book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}
