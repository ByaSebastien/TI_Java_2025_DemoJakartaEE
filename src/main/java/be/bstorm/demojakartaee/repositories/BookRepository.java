package be.bstorm.demojakartaee.repositories;

import be.bstorm.demojakartaee.entities.Book;

import java.util.Optional;

public interface BookRepository {

    Optional<Book> findByIsbn(String isbn);
}
