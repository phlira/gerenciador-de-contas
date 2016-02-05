package br.com.gerenciador.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas-mysql");
	private static EntityManagerFactory entityMFactoryTest = Persistence.createEntityManagerFactory("contas-hsqldb");
	
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    public EntityManager getEntityManagerTest() {
    	return entityMFactoryTest.createEntityManager();
    }
	
}
