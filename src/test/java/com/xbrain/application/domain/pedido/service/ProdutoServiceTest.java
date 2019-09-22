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

import com.xbrain.application.domain.pedido.dao.ProdutoRepository;
import com.xbrain.application.domain.pedido.entity.Produto;
import com.xbrain.application.domain.pedido.entity.ProdutoPK;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoServiceTest {

	@Autowired
	private ProdutoService clienteService;
	
	@MockBean
	private ProdutoRepository dbProduto;
	
	@Test
	public void testeBuscarListaProduto() throws Exception {
		Mockito.when(dbProduto.findAll()).thenReturn(new ArrayList<Produto>());
		assertThat(clienteService.buscarListaProduto()).isEqualTo(new ArrayList<Produto>());
	}
	
	@Test
	public void testeSaveProduto() throws Exception {
				
		Produto produto = new Produto();
		produto.setId(new ProdutoPK());
				
		Mockito.when(dbProduto.save(produto)).thenReturn(produto);
		assertThat(clienteService.saveProduto("{\"idProduto\":1,\"descricao\":\"\"}")).isNull();
	}
}