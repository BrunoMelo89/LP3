package br.com.impacta.modelo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.impacta.modelo.Contato;

public class CarregaContato {
	public static void main(String[] args) {

	    EntityManagerFactory factory = Persistence.
	        createEntityManagerFactory("impacta-persistence");
	    EntityManager manager = factory.createEntityManager();

	    Contato encontrado = manager.find(Contato.class, 1L);
	    System.out.println(encontrado.getNome());    

	    manager.close();
	  }


}
