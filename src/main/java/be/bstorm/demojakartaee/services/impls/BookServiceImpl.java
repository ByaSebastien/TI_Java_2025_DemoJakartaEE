package be.bstorm.demojakartaee.services.impls;

import be.bstorm.demojakartaee.entities.Book;
import be.bstorm.demojakartaee.repositories.BookRepository;
import be.bstorm.demojakartaee.repositories.impls.BookRepositoryImpl;
import be.bstorm.demojakartaee.services.BookService;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl() {
        this.bookRepository = new BookRepositoryImpl();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow();
    }
}
