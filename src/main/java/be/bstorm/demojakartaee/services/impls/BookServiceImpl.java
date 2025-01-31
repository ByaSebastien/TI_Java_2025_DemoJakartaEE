package be.bstorm.demojakartaee.services.impls;

import be.bstorm.demojakartaee.entities.Book;
import be.bstorm.demojakartaee.repositories.BookRepository;
import be.bstorm.demojakartaee.services.BookService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.List;

@SessionScoped
public class BookServiceImpl implements BookService, Serializable {

    @Inject
    private BookRepository bookRepository;


    public BookServiceImpl() {}

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow();
    }

    @Override
    public Book save(Book book) {
        if (bookRepository.existByIsbn(book.getIsbn())) {
            throw new RuntimeException("Book already exists");
        }
        return bookRepository.save(book);
    }

    @Override
    public void update(String id, Book book) {
        if (!id.equals(book.getIsbn())) {
            if (bookRepository.existByIsbn(book.getIsbn())) {
                throw new RuntimeException("Book already exists");
            }
        }
        bookRepository.update(id, book);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn).orElseThrow(
                () -> new RuntimeException("Book not found")
        );
        bookRepository.delete(book);
    }
}
