package be.bstorm.demojakartaee.services;

import be.bstorm.demojakartaee.entities.Book;

public interface BookService {

    Book findByIsbn(String isbn);
}
