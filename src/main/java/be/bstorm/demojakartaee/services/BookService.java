package be.bstorm.demojakartaee.services;

import be.bstorm.demojakartaee.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findByIsbn(String isbn);
}
