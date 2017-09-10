package teste;

import controle.EntityManagerUtil;
import javax.persistence.EntityManager;
import modelo.Estado;
import modelo.Pais;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirEstado {

    EntityManager entityManager;

    public TestePersistirEstado() {
    }

    @Before
    public void setUp() {
        entityManager = EntityManagerUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        entityManager.close();
    }

    @Test
    public void persistir() {
        Boolean exception = false;
        try {
            Estado estado = new Estado();
            estado.setCodigo(26)
                  .setNome("PERNAMBUCO")
                  .setUf("PE")
                  .setPais(entityManager.find(Pais.class, 1058));
            entityManager.getTransaction().begin();
            entityManager.persist(estado);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            exception =true;
            ex.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }

}
