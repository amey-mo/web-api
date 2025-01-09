package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class Author {
    public int id;
    public String name;
    public int booksWritten;
    private List<Book> books;

}
