package be.bstorm.demojakartaee.repositories;

import be.bstorm.demojakartaee.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
}
