package com.xbrain.application.rest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.xbrain.application.domain.pedido.entity.Pedido;
import com.xbrain.application.domain.pedido.service.PedidoService;

@RunWith(SpringJUnit4ClassRunner.class)
public class PedidoResourceTest {

	private MockMvc mockMvc;
	
	@Mock
	private PedidoService pedidoService;
	
	@InjectMocks
	private PedidoResource pedidoResource;	
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(pedidoResource).build();
	}

	@Test
	public void testeObterListaPedido() throws Exception {
		
		when(pedidoService.buscarListaPedido()).thenReturn(new ArrayList<Pedido>());
		
		mockMvc.perform(get("/pedido/list"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		
		verify(pedidoService).buscarListaPedido();
	}
	
	@Test
	public void testeSavePedido() throws Exception {		
		mockMvc.perform(post("/pedido/save").content("{}"))
			.andExpect(status().isOk())
			.andExpect(content().string(""));
		
		verify(pedidoService).savePedido("{}");;
	}
}