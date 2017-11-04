package br.com.impacta.tarefas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.impacta.model.Tarefa;
import br.com.impacta.model.TarefaDao;

@Controller
	public class TarefasController {
	  @RequestMapping("novaTarefa")
	  public String form() {
	    return "tarefa/formulario";
	  }

	  @RequestMapping("adicionaTarefa")
	  public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
	    
	    if(result.hasFieldErrors("descricao")) {
	      return "tarefa/formulario";
	    }    

	    TarefaDao dao = new TarefaDao();
	    dao.adiciona(tarefa);
	    return "tarefa/adicionada";
	  }

}
