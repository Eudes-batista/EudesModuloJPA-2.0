package teste;

import controle.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Cidade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConsultarCidade {

    EntityManager entityManager;

    public ConsultarCidade() {
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

        Query  query = entityManager.createNamedQuery("cidade.listaPorEstado");
        List<Cidade> listarCidades = query.getResultList();
        System.out.println(listarCidades.size());
        for (Cidade listarCidade : listarCidades) {
            System.out.println("Estado "+listarCidade.getEstado().getNome()+" Cidade: "+listarCidade.getNome());
        }
    }

}
