/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.EntityManagerUtil;
import javax.persistence.EntityManager;
import modelo.Pais;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrador
 */
public class TestePersistirPais {

    private EntityManager entityManager;

    public TestePersistirPais() {
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
        Pais pais = new Pais();
        pais.setCodigo(639);
        pais.setNome("Argentina");
        pais.setIso("Arg");
        entityManager.getTransaction().begin();
        entityManager.persist(pais);
        entityManager.getTransaction().commit();

    }

}
