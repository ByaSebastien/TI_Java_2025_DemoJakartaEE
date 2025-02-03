package be.bstorm.demojakartaee.repositories.impls;

import be.bstorm.demojakartaee.entities.User;
import be.bstorm.demojakartaee.repositories.UserRepository;
import be.bstorm.demojakartaee.utils.EmfFactoryUtils;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.Optional;

@SessionScoped
public class UserRepositoryImpl implements UserRepository, Serializable {

    private final EntityManagerFactory emf;

    public UserRepositoryImpl() {
        this.emf = EmfFactoryUtils.getEmfFactory();
    }

    @Override
    public void save(User user) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        try(EntityManager em = emf.createEntityManager()) {
            Query query = em.createQuery("SELECT count(u) > 0 FROM User u WHERE u.username = :username");
            query.setParameter("username", username);
            return  (boolean) query.getSingleResult();
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try(EntityManager em = emf.createEntityManager()) {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
            query.setParameter("username", username);
            return  Optional.of((User) query.getSingleResult());
        }
    }
}
