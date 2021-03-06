package teste;

import controle.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Pais;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsultarPais {

    EntityManager entityManager;

    public ConsultarPais() {
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
    public void consultar() {

        //Query  query = entityManager.createNamedQuery("pais.listaTodos");
        Query query = entityManager.createNamedQuery("pais.listaPorNome");
        query.setParameter("nome", "BRASIL");
        Pais pais = (Pais) query.getSingleResult();
        System.out.println(pais.getNome());
    }

}
