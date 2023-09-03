package ru.mityugov.testserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mityugov.testserver.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
