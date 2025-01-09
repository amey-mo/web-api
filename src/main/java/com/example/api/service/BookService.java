package com.example.api.service;

import com.example.api.entities.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    // List to store books
    private List<Book> books = new ArrayList<>();

    // Constructor to initialize some default books
    public BookService() {
        books.add(new Book(1, "Java Programming", 2017));
        books.add(new Book(2, "Spring Boot Essentials", 2021));
    }

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Add a new book
    public Book addBook(Book book) {
        books.add(book); // Add the book to the list
        return book;
    }

    // Update an existing book
    public Book updateBook(int id, Book updatedBookDetails) {
        for (Book book : books) {
            if (book.getId() == id) {
                // Update the book details
                book.setTitle(updatedBookDetails.getTitle());
                book.setYearPublished(updatedBookDetails.getYearPublished());
                return book; // Return the updated book
            }
        }
        throw new IllegalArgumentException("Book with ID " + id + " not found.");
    }

    // Delete a book by ID
    public List<Book> deleteBookById(int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Book with ID " + id + " not found.");
        }
        return books; // Return the updated list of books
    }
}