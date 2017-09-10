/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.EntityManagerUtil;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import modelo.TipoEndereco;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrador
 */
public class TestePersistirTipoEndereco {
    
    private EntityManager entityManager;
    
    public TestePersistirTipoEndereco() {
    }
    
    @Before
    public void setUp() {
        entityManager =EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        entityManager.close();
    }
    
   
    @Test
    public void persistir() {

        TipoEndereco endereco = new TipoEndereco();
        endereco.setCodigo(2);
        endereco.setDescricao("Comercial");
        entityManager.getTransaction().begin();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<TipoEndereco>> erros = validator.validate(endereco);
        StringBuilder sb = new StringBuilder();
        if (erros.size() > 0) {
            for (ConstraintViolation<TipoEndereco> erro : erros) {
                sb.append("Erro :").append(erro.getMessage()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            entityManager.persist(endereco);
        }
        entityManager.getTransaction().commit();

    }
    
}
