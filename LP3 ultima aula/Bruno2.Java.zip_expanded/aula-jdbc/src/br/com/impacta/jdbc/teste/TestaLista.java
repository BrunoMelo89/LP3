package br.com.impacta.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.impacta.jdbc.dao.ContatoDao;
import br.com.impacta.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getContatos();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		for (Contato contato : contatos) {
			  System.out.println("Nome: " + contato.getNome());
			  System.out.println("Email: " + contato.getEmail());
			  System.out.println("Endere�o: " + contato.getEndereco());
			  System.out.println("Data de Nascimento: " + 
			 sdf.format(contato.getDataNascimento().getTime()) + "\n");
			}
	
		
	}

}
