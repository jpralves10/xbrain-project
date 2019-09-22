package com.xbrain.application.domain.pedido.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.xbrain.application.domain.pedido.dao.EntregaRepository;
import com.xbrain.application.domain.pedido.entity.Entrega;
import com.xbrain.application.domain.pedido.entity.EntregaPK;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntregaServiceTest {

	@Autowired
	private EntregaService entregaService;
	
	@MockBean
	private EntregaRepository dbEntrega;
	
	@Test
	public void testeBuscarListaEntrega() throws Exception {
		Mockito.when(dbEntrega.findAll()).thenReturn(new ArrayList<Entrega>());
		assertThat(entregaService.buscarListaEntrega()).isEqualTo(new ArrayList<Entrega>());
	}
	
	@Test
	public void testeReceiveMessage() throws Exception {
		
		List<String> listEntrega = new ArrayList<String>();
		listEntrega.add("1");
		listEntrega.add("");
		
		Entrega entrega = new Entrega();
		entrega.setId(new EntregaPK());
				
		Mockito.when(dbEntrega.save(entrega)).thenReturn(entrega);
	}
}