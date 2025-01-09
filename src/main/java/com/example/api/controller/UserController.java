package com.example.api.controller;

import com.example.api.entities.Author;
import com.example.api.entities.Book;
import com.example.api.service.AuthorService;
import com.example.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1") // Main endpoint
public class UserController {
    @Autowired
    private final AuthorService authorService;
    @Autowired
    private final BookService bookService;

    // Constructor-based Dependency Injection
    public UserController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    // ---- AUTHOR ENDPOINTS ----

    // Fetch all authors
    @GetMapping(path = "/authors")
    public ResponseEntity<Author[]> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
}