package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;              // Book ID
    private String title;        // Title of the book
    private int yearPublished;   // Year the book was published
}