/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.EntityManagerUtil;
import javax.persistence.EntityManager;
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
    public void persistir(){
        TipoEndereco tipoEndereco = new TipoEndereco();
        tipoEndereco.setCodigo(01);
        tipoEndereco.setDescricao("Residencial");
        entityManager.getTransaction().begin();
        entityManager.persist(tipoEndereco);
        entityManager.getTransaction().commit();
        
    }
    
}
