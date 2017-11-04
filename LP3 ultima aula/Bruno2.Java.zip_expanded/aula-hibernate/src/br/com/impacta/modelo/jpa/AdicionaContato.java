package br.com.impacta.modelo.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.impacta.modelo.Contato;

public class AdicionaContato {

	
		  public static void main(String[] args) {

			    Contato contato = new Contato();
			    contato.setNome("Impacta");
			    contato.setEndereco("Avenida Rudge");
			    contato.setEmail("victor@impacta.com.br");
			    contato.setDataNascimento(Calendar.getInstance());

			    EntityManagerFactory factory = Persistence.
			         createEntityManagerFactory("impacta-persistence");
			    EntityManager manager = factory.createEntityManager();

			    manager.getTransaction().begin();    
			    manager.persist(contato);
			    manager.getTransaction().commit();  

			    System.out.println("ID do contato:" + contato.getId());
			    manager.close();
			  }
			


	}


