package be.bstorm.demojakartaee.repositories.impls;

import be.bstorm.demojakartaee.entities.Book;
import be.bstorm.demojakartaee.repositories.BookRepository;
import be.bstorm.demojakartaee.utils.EmfFactoryUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    private final EntityManagerFactory emf;

    public BookRepositoryImpl() {
        emf = EmfFactoryUtils.getEmfFactory();
    }

    @Override
    public List<Book> findAll() {
        try(EntityManager em = emf.createEntityManager()) {
            return em.createQuery("select b from Book b", Book.class).getResultList();
        }
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        try(EntityManager em = emf.createEntityManager()) {
            return Optional.of(em.find(Book.class,isbn));
        }
    }
}
