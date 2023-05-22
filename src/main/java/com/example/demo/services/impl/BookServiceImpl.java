package com.example.demo.services.impl;

import com.example.demo.models.db.Book;
import com.example.demo.models.requests.CreateRequest;
import com.example.demo.models.requests.UpdateRequest;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.exceptions.NotFoundException;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book create(CreateRequest request) {
        Book book = new Book(request);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(Long id) {
        Book book = bookRepository.findById(id).orElse(null);

        if (null == book) {
            throw new NotFoundException("Book");
        }

        return book;
    }

    @Override
    public Book update(Long id, UpdateRequest request) {
        Book book = get(id);

        book.setName(request.getName());
        book.setAuthor(request.getAuthor());

        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        Book book = get(id);

        bookRepository.delete(book);
    }

}
