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

import com.xbrain.application.domain.pedido.dao.ClienteRepository;
import com.xbrain.application.domain.pedido.entity.Cliente;
import com.xbrain.application.domain.pedido.entity.ClientePK;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {

	@Autowired
	private ClienteService clienteService;
	
	@MockBean
	private ClienteRepository dbCliente;
	
	@Test
	public void testeBuscarListaCliente() throws Exception {
		Mockito.when(dbCliente.findAll()).thenReturn(new ArrayList<Cliente>());
		assertThat(clienteService.buscarListaCliente()).isEqualTo(new ArrayList<Cliente>());
	}
	
	@Test
	public void testeSaveCliente() throws Exception {
				
		Cliente cliente = new Cliente();
		cliente.setId(new ClientePK());
				
		Mockito.when(dbCliente.save(cliente)).thenReturn(cliente);
		//assertThat(clienteService.saveCliente("{\"idCliente\":1,\"nome\":\"\"}")).isExactlyInstanceOf(Cliente.class);
	}
}
