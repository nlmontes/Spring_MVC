package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido") //mapeia todas as requisiçoes para /pedido, mapeado no nível da classe
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/formulario")   // /formulario é mapeado no nível da action
	public String formulario(RequisicaoNovoPedido requsicao) {
		
		//retorna a pagina a ser renderizada pelo usuario
		return "pedido/formulario";
	}
	
	//@Valid = integra a execução da validação ao componente a ser validado
	//BindingResult = retorna o resultado da validação
	@PostMapping("/novo") //mapeia para o formulário na uri /pedio/novo no nivel da action
	public String novo(@Valid RequisicaoNovoPedido requsicao, BindingResult result) {
		
		if (result.hasErrors()) {
			return "pedido/formulario";
		}
		
		Pedido pedido = requsicao.toPedido();
		pedidoRepository.save(pedido);
		
		return "redirect:/home"; 
	}

}
