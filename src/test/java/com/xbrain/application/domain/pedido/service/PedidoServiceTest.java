package com.xbrain.application.domain.pedido.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.xbrain.application.domain.pedido.dao.PedidoRepository;
import com.xbrain.application.domain.pedido.entity.Pedido;
import com.xbrain.application.domain.pedido.entity.PedidoPK;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoServiceTest {

	@Autowired
	private PedidoService pedidoService;
	
	@MockBean
	private PedidoRepository dbPedido;
	
	@Test
	public void testeBuscarListaPedido() throws Exception {
		Mockito.when(dbPedido.findAll()).thenReturn(new ArrayList<Pedido>());
		assertThat(pedidoService.buscarListaPedido()).isEqualTo(new ArrayList<Pedido>());
	}
	
	@Test
	public void testeSavePedido() throws Exception {
				
		Pedido pedido = new Pedido();
		pedido.setId(new PedidoPK());
				
		Mockito.when(dbPedido.save(pedido)).thenReturn(pedido);
		//assertThat(pedidoService.savePedido("{\"idPedido\":1,\"descricao\":\"\"}")).isNull();
	}
}