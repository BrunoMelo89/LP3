<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.jpa.Contato"%>
<%@page import="java.util.List"%>
<%@page import="modelo.jpa.ContatoDao"%>
<html>
<body>
<table>
<% ContatoDao dao = new ContatoDao();
List<Contato> contatos = dao.BuscaTotal();
for (Contato contato : contatos ) { %>
<tr><td><%=contato.getNome() %></td>
<td><%=contato.getEmail() %></td>
<td><%=contato.getEndereco() %></td>
<td><% 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	out.print(sdf.format(contato.getDataNascimento().getTime()));
	 %></td>
</tr>
<% } %>
</table>
</body>
</html>