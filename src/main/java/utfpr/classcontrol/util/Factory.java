package utfpr.classcontrol.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("classcontrol");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
