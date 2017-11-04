package br.com.impacta.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.impacta.model.ConnectionFactory;

public class TarefaDao {

	public void adiciona(Tarefa t) {
		EntityManager manager = new ConnectionFactory().getConnection();

		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		System.out.println("ID do contato: " + t.getId());
		manager.close();
	}

	public List<Tarefa> BuscaTotal() {
		EntityManager manager = new ConnectionFactory().getConnection();
		Query query = manager.createQuery("select c from Contato as c");

		List<Tarefa> lista = query.getResultList();
		manager.close();
		return lista;
	}

	public void Remove(int id) {
		EntityManager manager = new ConnectionFactory().getConnection();
		Tarefa contato = manager.find(Tarefa.class, id);
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();

		manager.close();
	}

	public void Atualiza(Tarefa contato) {
		EntityManager manager = new ConnectionFactory().getConnection();
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		manager.close();

	}

	
}
