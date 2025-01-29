package be.bstorm.demojakartaee.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmfFactoryUtils {

    public static EntityManagerFactory emf;

    public static EntityManagerFactory getEmfFactory() {
        emf = emf != null ? emf : Persistence.createEntityManagerFactory("jakarta_demo");
        return emf;
    }
}
