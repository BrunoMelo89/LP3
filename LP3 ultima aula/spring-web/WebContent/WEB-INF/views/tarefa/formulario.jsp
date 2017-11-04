<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <body>
  	<form action="adicionaTarefa" method="post">
    <h3>Adicionar tarefas</h3>
      <form:errors path="tarefa.descricao"/>
      Descrição: <br />     
      <textarea name="descricao" rows="5" cols="100"></textarea><br />
      <input type="submit" value="Adicionar">
    </form>
  </body>
</html>
