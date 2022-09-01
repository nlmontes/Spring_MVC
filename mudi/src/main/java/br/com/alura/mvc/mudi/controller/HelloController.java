package br.com.alura.mvc.mudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Controller é um guarda-chuva de actions
//Essa notation já faz a integração dessa classe com o Spring
@Controller
public class HelloController {
	
	//Esse método é uma action, que retorna uma String (hello)
	//Essa notation informa que /hello é uma url direcionada para o método hello()
	@GetMapping("/hello")
	//public String hello(HttpServletRequest request) {
	//Model: interface fornecida pelo Spring que mapeia a requisição
	public String hello(Model model) {
		
		//model: utiliza-se a camada do Spring mais alto nivel, e não a camada Servlet (HttpServlet)
		model.addAttribute("nome", "Mundo");
		
		//retorna uma String que representa uma view, que no caso do Thymeleaf fica dentro da pasta templates
		return "hello";
		
	}

}
