package modelo.jpa;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import teste.ConnectionFactory;

public class ContatoDao {

	public void adiciona(Contato contato) {
		EntityManager manager = new ConnectionFactory().getConnection();

		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		System.out.println("ID do contato: " + contato.getId());
		manager.close();
	}

	public List<Contato> BuscaTotal() {
		EntityManager manager = new ConnectionFactory().getConnection();
		Query query = manager.createQuery("select c from Contato as c");

		List<Contato> lista = query.getResultList();
		manager.close();
		return lista;
	}

	public Contato BuscaId(int id) {
		EntityManager manager = new ConnectionFactory().getConnection();
		Contato contato = manager.find(Contato.class, id);
		System.out.println(contato.getNome());
		manager.close();
		return contato;
	}

	public void Remove(int id) {
		EntityManager manager = new ConnectionFactory().getConnection();
		Contato contato = manager.find(Contato.class, id);
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();

		manager.close();
	}

	public void Atualiza(Contato contato) {
		EntityManager manager = new ConnectionFactory().getConnection();
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		manager.close();

	}

	
}
