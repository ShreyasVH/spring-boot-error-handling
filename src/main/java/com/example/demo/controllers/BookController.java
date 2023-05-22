package com.example.demo.controllers;

import com.example.demo.models.db.Book;
import com.example.demo.models.requests.CreateRequest;
import com.example.demo.models.requests.UpdateRequest;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.responses.Response;

import java.util.List;

@RestController
public class BookController
{
    @Autowired
    private BookService bookService;

    @PostMapping("/v1/books")
    public Book create(@RequestBody CreateRequest request)
    {
        return this.bookService.create(request);
    }

    @GetMapping("/v1/books")
    public List<Book> list()
    {
        return this.bookService.list();
    }

    @GetMapping("/v1/books/{id}")
    public Response get(@PathVariable Long id) {
        return new Response(this.bookService.get(id));
    }

    @PutMapping("/v1/books/{id}")
    public Book update(@PathVariable Long id, @RequestBody UpdateRequest request) {
        return this.bookService.update(id, request);
    }

    @DeleteMapping("/v1/books/{id}")
    public String delete(@PathVariable Long id) {
        this.bookService.delete(id);
        return "Success";
    }
}
