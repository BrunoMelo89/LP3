package br.com.impacta.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.impacta.jdbc.ConnectionFactory;
import br.com.impacta.jdbc.dao.ContatoDao;
import br.com.impacta.jdbc.modelo.Contato;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		
		Connection c = new ConnectionFactory().getConnection();
		System.out.println("Abriu !!!  :D");
		
		 Contato contato = new Contato();
		 contato.setNome("Impacta");
		 contato.setEmail("contato@fit.com.br");
		 contato.setEndereco("Av. Rudge");
		 contato.setDataNascimento(Calendar.getInstance());
		 
		 // grave nessa conexão!!!
		 ContatoDao dao = new ContatoDao();
		 
		 // método elegante
		 //dao.adiciona(contato);
		 dao.remove(contato);
		 System.out.println("Gravado!");

		 c.close();
		
	}
}
