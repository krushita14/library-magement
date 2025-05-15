package com.example.library.controller;

import com.example.library.exception.BookNotFoundException;
import com.example.library.model.Books;
import com.example.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    public BookControllerTest() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void testSearchBooksByTitle_Found() throws Exception {
        String title = "Harry";
        List<Books> mockBooks = new ArrayList<>();
        mockBooks.add(new Books("1", "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "1999"));

        when(bookService.searchBooksByTitle(title)).thenReturn(mockBooks);

        mockMvc.perform(get("/api/books/search")
                        .param("title", title)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].title").value("Harry Potter and the Philosopher's Stone"));

        verify(bookService, times(1)).searchBooksByTitle(title);
    }

    @Test
    void testSearchBooksByTitle_NotFound() throws Exception {
        String title = "Unknown";
        when(bookService.searchBooksByTitle(title)).thenThrow(new BookNotFoundException("No books found with title containing: " + title));

        mockMvc.perform(get("/api/books/search")
                        .param("title", title)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("No books found with title containing: " + title));

        verify(bookService, times(1)).searchBooksByTitle(title);
    }
}
