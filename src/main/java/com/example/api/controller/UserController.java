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

    // Add a new author
    @PostMapping(path = "/authors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author[]> addAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.addAuthor(author));
    }

    // Update an existing author
    @PutMapping(path = "/authors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.updateAuthor(author));
    }

    // Delete an author by ID
    @DeleteMapping(path = "/authors/{id}")
    public ResponseEntity<Author[]> deleteAuthor(@PathVariable int id) {
        return ResponseEntity.ok(authorService.deleteAuthorById(id));
    }

    // ---- BOOK ENDPOINTS ----

    // Fetch all books
    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // Add a new book
    @PostMapping(path = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    // Update a book by ID
    @PutMapping(path = "/books/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        return ResponseEntity.ok(bookService.updateBook(id, updatedBook));
    }

    // Delete a book by ID
    @DeleteMapping(path = "/books/{id}")
    public ResponseEntity<List<Book>> deleteBook(@PathVariable int id) {
        return ResponseEntity.ok(bookService.deleteBookById(id));
    }
}