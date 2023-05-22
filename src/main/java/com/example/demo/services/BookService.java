package com.example.demo.services;

import com.example.demo.models.db.Book;
import com.example.demo.models.requests.CreateRequest;
import com.example.demo.models.requests.UpdateRequest;

import java.util.List;

public interface BookService
{
    Book create(CreateRequest request);
    List<Book> list();
    Book get(Long id);
    Book update(Long id, UpdateRequest request);
    void delete(Long id);
}
