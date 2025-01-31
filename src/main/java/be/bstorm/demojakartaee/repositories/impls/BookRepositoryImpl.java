package be.bstorm.demojakartaee.repositories.impls;

import be.bstorm.demojakartaee.entities.Book;
import be.bstorm.demojakartaee.repositories.BookRepository;
import be.bstorm.demojakartaee.utils.EmfFactoryUtils;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@SessionScoped
public class BookRepositoryImpl implements BookRepository, Serializable {

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

    @Override
    public Book save(Book book) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            return book;
        }
    }

    @Override
    public boolean existByIsbn(String isbn) {
        try(EntityManager em = emf.createEntityManager()) {
            Query query = em.createQuery("select count(b) > 0 from Book b where b.isbn = :isbn");
            query.setParameter("isbn", isbn);
            return (Boolean) query.getSingleResult();
        }
    }

    @Override
    public void update(String id, Book book) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Book oldBook = em.find(Book.class, id);
            oldBook.setIsbn(book.getIsbn());
            oldBook.setTitle(book.getTitle());
            oldBook.setAuthor(book.getAuthor());
            oldBook.setDescription(book.getDescription());

            em.getTransaction().commit();
        }
    }

    @Override
    public void delete(Book book) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            book = em.merge(book);
            em.remove(book);
            em.getTransaction().commit();
        }
    }
}
