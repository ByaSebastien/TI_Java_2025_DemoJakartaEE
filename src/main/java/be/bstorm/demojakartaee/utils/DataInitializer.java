package be.bstorm.demojakartaee.utils;

import be.bstorm.demojakartaee.entities.Book;
import be.bstorm.demojakartaee.repositories.impls.BookRepositoryImpl;
import be.bstorm.demojakartaee.services.BookService;
import be.bstorm.demojakartaee.services.impls.BookServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.List;

@WebListener
public class DataInitializer implements ServletContextListener {

    private final BookService bookService;


    public DataInitializer() {
        this.bookService = new BookServiceImpl(new BookRepositoryImpl());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        List<Book> books = List.of(
                new Book("978-0-123456-47-2", "Spring Boot Basics", "John Doe", "Introduction à Spring Boot"),
                new Book("978-0-123456-47-3", "Effective Java", "Joshua Bloch", "Meilleures pratiques Java"),
                new Book("978-0-123456-47-4", "Clean Code", "Robert C. Martin", "Écriture de code propre et maintenable"),
                new Book("978-0-123456-47-5", "Microservices with Spring", "Mark Heckler", "Guide sur les microservices"),
                new Book("978-0-123456-47-6", "Java Concurrency", "Brian Goetz", "Programmation concurrente en Java"),
                new Book("978-0-123456-47-7", "Design Patterns", "Erich Gamma", "Patterns de conception en Java"),
                new Book("978-0-123456-47-8", "The Pragmatic Programmer", "Andy Hunt", "Conseils pour les développeurs"),
                new Book("978-0-123456-47-9", "Refactoring", "Martin Fowler", "Techniques de refactoring en Java"),
                new Book("978-0-123456-48-0", "Java Performance", "Charlie Hunt", "Optimisation des performances Java"),
                new Book("978-0-123456-48-1", "Head First Java", "Kathy Sierra", "Apprentissage interactif de Java")
        );

        books.forEach(bookService::save);
    }
}
