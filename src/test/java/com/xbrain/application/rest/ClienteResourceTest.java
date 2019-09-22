package com.xbrain.application.rest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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

import com.xbrain.application.domain.pedido.entity.Cliente;
import com.xbrain.application.domain.pedido.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClienteResourceTest {

	private MockMvc mockMvc;
	
	@Mock
	private ClienteService clienteService;
	
	@InjectMocks
	private ClienteResource clienteResource;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(clienteResource).build();
	}

	@Test
	public void testeObterListaCliente() throws Exception {
		
		when(clienteService.buscarListaCliente()).thenReturn(new ArrayList<Cliente>());
		
		mockMvc.perform(get("/cliente/list"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		
		verify(clienteService).buscarListaCliente();
	}
	
	@Test
	public void testeSaveCliente() throws Exception {		
		mockMvc.perform(post("/cliente/save").content("{}"))
			.andExpect(status().isOk())
			.andExpect(content().string(""));
		
		verify(clienteService).saveCliente("{}");;
	}
}