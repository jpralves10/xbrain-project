package com.xbrain.application.rest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.xbrain.application.domain.pedido.entity.Entrega;
import com.xbrain.application.domain.pedido.service.EntregaService;

@RunWith(SpringJUnit4ClassRunner.class)
public class EntregaResourceTest {

	private MockMvc mockMvc;
	
	@Mock
	private EntregaService entregaService;
	
	@InjectMocks
	private EntregaResource entregaResource;	
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(entregaResource).build();
	}

	@Test
	public void testeObterListaEntrega() throws Exception {
		
		when(entregaService.buscarListaEntrega()).thenReturn(new ArrayList<Entrega>());
		
		mockMvc.perform(get("/entrega/list"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		
		verify(entregaService).buscarListaEntrega();
	}
}