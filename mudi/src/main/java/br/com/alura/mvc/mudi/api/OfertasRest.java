package br.com.alura.mvc.mudi.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	//@RequestBody: informar que o objeto requisicao deve ser preenchido com os valores vindos na requisição
	//@Valid = integra a execução da validação ao componente a ser validado
	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		
		//final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		if (pedidoBuscado.isEmpty()) {
			return null;
		}

		Pedido pedido = pedidoBuscado.get();

		Oferta nova = requisicao.toOferta();
		nova.setPedido(pedido);
		
		//pedido.setDataEntrega(LocalDate.parse(requisicao.dataDaEntrega, formatter));

		pedido.getOfertas().add(nova);

		pedidoRepository.save(pedido);

		return nova;

	}

}
