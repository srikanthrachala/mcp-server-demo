package com.springcoding.springboot.mcp;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    @Tool(name = "get_books", description = "Get a list of books")
    public List<Book> getBooks() {
        return books;
    }

    @Tool(name = "get_book_by_title", description = "Get a single book by title")
    public Book getBook(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    @PostConstruct
    public void init() {
        books.addAll(List.of(
                new Book("Pride and Prejudice",
                        "Jane Austen",
                        "This is Jane Austen's best-loved and most intimately known novel."),
                new Book("Harry Potter - a Magical Year",
                        "J. K. Rowling",
                        "A Magical Year takes readers on an unforgettable journey through the seasons at Hogwarts.")
        ));
    }
}
