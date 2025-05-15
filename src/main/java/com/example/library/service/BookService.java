package com.example.library.service;

import com.example.library.exception.BookNotFoundException;
import com.example.library.model.Books;
import com.example.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<Books> addBook(List<Books> books) {
        return bookRepository.saveAll(books);
    }

    public Books updateBook(String id, Books book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public List<Books> searchBooksByTitle(String title) {
        List<Books> books = bookRepository.findByTitle(title);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found with title containing: " + title);
        }
        return books;
    }
}
