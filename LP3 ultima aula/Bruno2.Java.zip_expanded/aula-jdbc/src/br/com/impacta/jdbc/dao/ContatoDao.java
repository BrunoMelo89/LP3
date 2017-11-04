package br.com.impacta.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.impacta.jdbc.ConnectionFactory;
import br.com.impacta.jdbc.modelo.Contato;

public class ContatoDao {
	   // a conexão com o banco de dados
	   private Connection Connection;
	 
	   public ContatoDao() {
	     this.Connection = new ConnectionFactory().getConnection();
	   }
	   public void adiciona(Contato contato) {
		     String sql = "insert into contatos " +
		             "(nome,email,endereco,dataNascimento)" +
		             " values (?,?,?,?)";
		 
		     try {
		         // prepared statement para inserção
		         PreparedStatement stmt = Connection.prepareStatement(sql);
		 
		         // seta os valores
		         stmt.setString(1,contato.getNome());
		         stmt.setString(2,contato.getEmail());
		         stmt.setString(3,contato.getEndereco());
		         stmt.setDate(4, (java.sql.Date) new Date(
		                 	contato.getDataNascimento().getTimeInMillis()));
		 
		         // executa
		         stmt.execute();
		         stmt.close();
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		     }
		     public List<Contato> getContatos() {
		    	    try {
		    		List<Contato> contatos = new ArrayList<Contato>();
		    		PreparedStatement stmt = this.Connection.
		    	      		prepareStatement("select * from contatos");
		    		ResultSet rs = stmt.executeQuery();
		    		while (rs.next()) {
		    			// criando o objeto Contato
		    			Contato contato = new Contato();
		    			contato.setId(rs.getLong("id"));
		    			contato.setNome(rs.getString("nome"));
		    			contato.setEmail(rs.getString("email"));
		    			contato.setEndereco(rs.getString("endereco"));
		    			// montando a data através do Calendar
		    			Calendar data = Calendar.getInstance();
		    			data.setTime(rs.getDate("dataNascimento"));
		    			contato.setDataNascimento(data);
		    			// adicionando o objeto à lista
		    			contatos.add(contato);
		    		}
		    		rs.close();
		    		stmt.close();
		    		return contatos;
		    	    } catch (SQLException e) {
		    		throw new RuntimeException(e);
		    	    }
		    	}
		     
		     public void altera(Contato contato) {
		         String sql = "update contatos set nome=?, email=?,"+
		                 "endereco=?, dataNascimento=? where id=?";
		     
		         try {
		             PreparedStatement stmt = Connection
		                     .prepareStatement(sql);
		             stmt.setString(1, contato.getNome());
		             stmt.setString(2, contato.getEmail());
		             stmt.setString(3, contato.getEndereco());
		             stmt.setDate(4, new Date(contato.getDataNascimento()
		                     .getTimeInMillis()));
		            
		             stmt.execute();
		             stmt.close();
		         } catch (SQLException e) {
		             throw new RuntimeException(e);
		         }
		     }
		     public void remove(Contato contato) {
		         try {
		             PreparedStatement stmt = Connection
		                     .prepareStatement("delete from contatos where id=3");
		            
		             stmt.execute();
		             stmt.close();
		         } catch (SQLException e) {
		             throw new RuntimeException(e);
		         }
		     }
		     public List<Contato> pesquisa(Contato contato){
		    	 Scanner sc = new Scanner(System.in);
		 		 System.out.print("Digite um texto:");
		 		int id =sc.nextInt();
		 		sc.close();
		 		try{
		 		List<Contato> contatos = new ArrayList<Contato>();	
		 		PreparedStatement stmt = Connection
	                     .prepareStatement("select * from contatos where id="+ id);

		 		ResultSet rs = stmt.executeQuery();
	    		while (rs.next()) {
	    			// criando o objeto Contato
	    			Contato contato1 = new Contato();
	    			contato1.setId(rs.getLong("id"));
	    			contato1.setNome(rs.getString("nome"));
	    			contato1.setEmail(rs.getString("email"));
	    			contato1.setEndereco(rs.getString("endereco"));
	    			// montando a data através do Calendar
	    			Calendar data = Calendar.getInstance();
	    			data.setTime(rs.getDate("dataNascimento"));
	    			contato1.setDataNascimento(data);
	    			// adicionando o objeto à lista
	    			contatos.add(contato1);
	    		}
	    		rs.close();
	    		stmt.close();
	    		return contatos;
	    	    } catch (SQLException e) {
	    		throw new RuntimeException(e);
	    	    }
		    	 
		    	 
		     }


		     
		     
 
}