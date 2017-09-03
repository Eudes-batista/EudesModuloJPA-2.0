package teste;

import controle.EntityManagerUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import modelo.PessoaFisica;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirPessoaFisica {

    EntityManager entityManager;

    public TestePersistirPessoaFisica() {
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
            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.setNome("Eudes batista do santos");
            pessoaFisica.setCpf("119.636.864-38");
            pessoaFisica.setRg("8.845.849");
            Calendar calendar = Calendar.getInstance();
            calendar.set(1996, 01, 10);
            pessoaFisica.setNacimento(calendar);
            pessoaFisica.setEmail("eudeskyo@hotmail.com");
            pessoaFisica.setTelefone("(81)98193-0692");
            pessoaFisica.setUsuario("eudeskyo");
            pessoaFisica.setSenha("123456");
            entityManager.getTransaction().begin();
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<PessoaFisica>> erros = validator.validate(pessoaFisica);
            StringBuilder sb = new StringBuilder();
            if (erros.size() > 0) {
                for (ConstraintViolation<PessoaFisica> erro : erros) {
                    sb.append("Erro :").append(erro.getMessage()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                entityManager.persist(pessoaFisica);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            exception = true;
            ex.printStackTrace();
        }

        Assert.assertEquals(false, exception);
    }

}
