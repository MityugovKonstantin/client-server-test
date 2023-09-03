package ru.mityugov.testserver.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mityugov.testserver.dao.BookDao;
import ru.mityugov.testserver.entities.Book;
import ru.mityugov.testserver.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDao> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDao> booksDao = new ArrayList<>();
        for (Book book : books) {
            booksDao.add(new BookDao(book.getId(), book.getName(), book.getAuthor()));
        }
        return booksDao;
    }

    public BookDao findById(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        return new BookDao(book.getId(), book.getName(), book.getAuthor());
    }
}
