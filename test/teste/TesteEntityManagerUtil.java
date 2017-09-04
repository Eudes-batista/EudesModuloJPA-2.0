package teste;

import controle.EntityManagerUtil;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteEntityManagerUtil {

    EntityManager entityManager;

    public TesteEntityManagerUtil() {
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
    }

}
