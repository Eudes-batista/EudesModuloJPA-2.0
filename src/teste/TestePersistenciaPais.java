package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pais;

public class TestePersistenciaPais {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AprendendoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Pais pais = new Pais();
        pais.setNome("COLOMBIA");
        pais.setIso("COL");
        entityManager.getTransaction().begin();
        entityManager.persist(pais);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        
    }
    
}
