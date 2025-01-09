package com.example.api.service;

import com.example.api.entities.Author;
import com.example.api.entities.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class AuthorService {

    // Class-level array to store authors
    private static Author[] authors = new Author[10];

    // Static block to initialize authors (replacing constructor)
    static {
        authors = new Author[]{
                new Author(1, "Amey", 1, null),
                new Author(2, "Karan", 5, Arrays.asList(
                        new Book(1, "Java Programming", 2017),
                        new Book(2, "Spring Boot Essentials", 2021)
                ))
        };
    }

    // Get all authors
    public static Author[] getAllAuthors() {
        return authors;
    }

    // Add a new author
    public static Author[] addAuthor(Author author) {
        Author[] extendedArray = Arrays.copyOf(authors, authors.length + 1);
        extendedArray[extendedArray.length - 1] = author;
        authors = extendedArray;
        return authors;
    }

    // Update an existing author
    public static Author updateAuthor(Author author) {
        Author updatedAuthor = null;

        // Find and update the author
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getId() == author.getId()) {
                authors[i].setName(author.getName());
                authors[i].setBooksWritten(author.getBooksWritten());
                authors[i].setBooks(author.getBooks());
                updatedAuthor = authors[i];
                break;
            }
        }

        if (updatedAuthor == null) {
            throw new IllegalArgumentException("Author with ID " + author.getId() + " not found.");
        }

        return updatedAuthor;
    }

    // Delete an author by ID
    public static Author[] deleteAuthorById(int id) {
        // Stream + Filter to remove an author
        Author[] updatedArray = Arrays.stream(authors)
                .filter(author -> !(author.getId() == id))
                .toArray(Author[]::new);

        authors = updatedArray;
        return authors;
    }
}