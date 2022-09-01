package br.com.alura.mvc.mudi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

//Utilizando Spring Data, nesse caso é utilizado uma interface para fazer link com a JpaRepository
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	//Não precisa declarar o EntityManager
	//@PersistenceContext	
	//private EntityManager em;
	
	//Todos os métodos base são herdados automaticamente, não sendo ncessesário declarar
		
	List<Pedido> findByStatus(StatusPedido status);

}
