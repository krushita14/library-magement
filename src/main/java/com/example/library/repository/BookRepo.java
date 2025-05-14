package com.example.library.repository;

import com.example.library.model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Books, String> {
}
