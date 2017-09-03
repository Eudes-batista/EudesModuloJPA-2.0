package teste;

import controle.EntityManagerUtil;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import modelo.Pais;

public class TesteValidacaoPais {

    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Pais pais = new Pais();
        pais.setNome("URUGUAI");
        pais.setIso("URU");
        entityManager.getTransaction().begin();
        Validator validetor = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validetor.validate(pais);
        if (erros.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Pais> erro : erros) {
                sb.append("Erro: ").append(erro.getMessage()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "AVISO", JOptionPane.ERROR_MESSAGE);
        } else {
            entityManager.persist(pais);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
