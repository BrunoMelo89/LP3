package modelo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



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
