package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

//Informa ao Spring que é um Controller
@Controller
@RequestMapping("/home")
public class HomeController {

	// @Autowired: informa ao Spring pra criar uma instância (PedidoRepository)
//	@Autowired
//	private PedidoRepositoryJpa repositoryJpa;
	
	@Autowired
	private PedidoRepository repository;

	@PersistenceContext
	private EntityManager em;

	// @GetMapping: Informa ao Spring que é uma url
	@GetMapping //mapeia para /home
	public String home(Model model, Principal principal) {

//		Pedido pedido = new Pedido();
//		pedido.setNomeProduto("Kindle");
//		pedido.setUrlImagem("https://m.media-amazon.com/images/I/51ij0YhqZTS._AC_SX679_.jpg");
//		pedido.setUrlProduto(
//				"https://www.amazon.com.br/Kindle-10a-gera%C3%A7%C3%A3o-ilumina%C3%A7%C3%A3o-embutida/dp/B07FQK1TS9/ref=sr_1_1?keywords=kindle&qid=1647979506&sprefix=kindl%2Caps%2C269&sr=8-1&ufe=app_do%3Aamzn1.fos.95de73c3-5dda-43a7-bd1f-63af03b14751");
//		pedido.setDescricao("Kindle para leitura digital");
//		List<Pedido> pedidos = Arrays.asList(pedido);

		// Usando JPQL no Spring Query query =
//		Query query = em.createQuery("select p from Pedido p", Pedido.class);
//		List<Pedido> pedidos = query.getResultList();

		// Usando JPA
		//List<Pedido> pedidos = repositoryJpa.recuperaTodosPedidos();

		// Usando Spring Data
		//List<Pedido> pedidos = repository.findAll();
		
		
		List<Pedido> pedidos = repository.findByUser(principal.getName());

		model.addAttribute("pedidos", pedidos);

		return "home";
	}
	
	@GetMapping("/{status}") //mapeia de acordo com o status a partir de /home/status
	public String porStatus(@PathVariable("status") String status, Model model) {
		
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home";
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onerror() {
		return "redirect:/home";
	}

}
