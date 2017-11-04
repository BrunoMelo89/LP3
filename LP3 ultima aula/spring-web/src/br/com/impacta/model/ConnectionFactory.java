package br.com.impacta.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	public EntityManager getConnection() {
		EntityManagerFactory factory = 
		Persistence.createEntityManagerFactory(
					"impacta-persistence");
		return factory.createEntityManager();
	}
	
}
