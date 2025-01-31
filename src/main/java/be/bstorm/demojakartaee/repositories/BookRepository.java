package be.bstorm.demojakartaee.repositories;

import be.bstorm.demojakartaee.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
    Book save(Book book);
    boolean existByIsbn(String isbn);
    void update(String id, Book book);
    void delete(Book book);
}
