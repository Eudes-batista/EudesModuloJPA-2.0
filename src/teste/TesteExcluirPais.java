package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pais;

public class TesteExcluirPais {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AprendendoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Pais pais = entityManager.find(Pais.class, 3);
        pais.setNome("COLOMBIA");
        pais.setIso("COL");
        entityManager.getTransaction().begin();
        entityManager.remove(pais);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
