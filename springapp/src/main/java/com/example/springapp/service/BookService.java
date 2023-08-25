package com.example.springapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.springapp.model.Book;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    // Constructor
    public BookService() {
        // For the sake of this example, let's assume we have some books in the system.
        books.add(new Book(1, "Book 1", "Author 1", 2000));
        books.add(new Book(2, "Book 2", "Author 2", 2005));
        books.add(new Book(3, "Book 3", "Author 1", 2010));
        books.add(new Book(4, "Book 4", "Author 3", 2015));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(Integer id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Book> getBooksByAuthor(String author) {
        System.out.println("getBooksByAuthor called with author: " + author);
    
        // Find books by author, or return an empty list if none found
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
    
        System.out.println("Found books: " + result);
        return result;
    }
    
    
    

    public List<Book> getBooksByYear(Integer year) {
        return books.stream().filter(book -> book.getYear().equals(year)).collect(Collectors.toList());
    }
}

