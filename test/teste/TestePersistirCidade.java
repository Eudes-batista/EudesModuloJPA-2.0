package teste;

import controle.EntityManagerUtil;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import modelo.Cidade;
import modelo.Estado;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirCidade {

    EntityManager entityManager;

    public TestePersistirCidade() {
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

        Cidade cidade = new Cidade();
        cidade.setCodigo(2611606);
        cidade.setNome("RECIFE");
        cidade.setEstado(entityManager.find(Estado.class,26));
        entityManager.getTransaction().begin();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Cidade>> erros = validator.validate(cidade);
        StringBuilder sb = new StringBuilder();
        if (erros.size() > 0) {
            for (ConstraintViolation<Cidade> erro : erros) {
                sb.append("Erro :").append(erro.getMessage()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            entityManager.persist(cidade);
        }
        entityManager.getTransaction().commit();

    }

}
