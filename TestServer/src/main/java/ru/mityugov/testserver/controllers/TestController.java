package ru.mityugov.testserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mityugov.testserver.dao.BookDao;
import ru.mityugov.testserver.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private final BookService bookService;

    @Autowired
    public TestController(BookService bookService) {
        this.bookService = bookService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public List<BookDao> findAll() {
        return bookService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/{id}")
    public BookDao getOne(@PathVariable("id") int id) {
        return bookService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/create")
    public void create(@RequestBody String data) {
        System.out.println("Create entry point with data = " + data);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PatchMapping("/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody String data) {
        System.out.println("Update entry point with id = " + id + " and data = " + data);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        System.out.println("Delete entry point with id = " + id);
    }
}
