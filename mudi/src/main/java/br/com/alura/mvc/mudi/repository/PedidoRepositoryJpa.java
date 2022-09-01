package br.com.alura.mvc.mudi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;

//@Repository: informa ao Spring que é um repository e ele passa a controlar essa classe
@Repository
public class PedidoRepositoryJpa {
	
	//@PersistenceContext: informa ao Spring que é um EntityManager
	@PersistenceContext	
	private EntityManager em;
	
	public List<Pedido> recuperaTodosPedidos() {
		
		//Usando JPQL no Spring
		Query query = em.createQuery("select p from Pedido p", Pedido.class);
		
		return query.getResultList();
		
	}

}
