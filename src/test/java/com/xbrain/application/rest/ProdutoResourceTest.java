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

import com.xbrain.application.domain.pedido.entity.Produto;
import com.xbrain.application.domain.pedido.service.ProdutoService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProdutoResourceTest {

	private MockMvc mockMvc;
	
	@Mock
	private ProdutoService produtoService;
	
	@InjectMocks
	private ProdutoResource produtoResource;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(produtoResource).build();
	}
	
	@Test
	public void testeObterListaProduto() throws Exception {
		
		when(produtoService.buscarListaProduto()).thenReturn(new ArrayList<Produto>());
		
		mockMvc.perform(get("/produto/list"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
		
		verify(produtoService).buscarListaProduto();
	}
	
	@Test
	public void testeSaveProduto() throws Exception {		
		mockMvc.perform(post("/produto/save").content("{}"))
			.andExpect(status().isOk())
			.andExpect(content().string(""));
		
		verify(produtoService).saveProduto("{}");;
	}
}