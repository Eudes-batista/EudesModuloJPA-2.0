package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager=null;

    public static EntityManager getEntityManager() {
        factory = factory == null ? Persistence.createEntityManagerFactory("AprendendoPU") : factory;
        return entityManager == null ? factory.createEntityManager() : entityManager;
    }

}
