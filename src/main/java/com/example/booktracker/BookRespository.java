package com.example.booktracker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class BookRespository implements IBook<Book> {

    private Map<Integer, Book> repository;
    
    public BookRespository() {
        repository = new HashMap<>();
    }

    @Override
    public void saveBook(Book book) {
        repository.put(book.getId(), book);
    }
    
}
