package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	@Query("select p from Pedido p join p.user u where u.username = :username ")
	List<Pedido> findByUser(@Param("username")String username);

}
