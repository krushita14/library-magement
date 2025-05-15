package com.example.library.repository;

import com.example.library.model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepo extends MongoRepository<Books, String> {

    List<Books> findByTitle(String title);
}
