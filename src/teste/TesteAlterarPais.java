package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pais;

public class TesteAlterarPais {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AprendendoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Pais pais = entityManager.find(Pais.class, 1);
        pais.setNome("BRASIL");
        pais.setIso("BRA");
        entityManager.getTransaction().begin();
        entityManager.merge(pais);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
