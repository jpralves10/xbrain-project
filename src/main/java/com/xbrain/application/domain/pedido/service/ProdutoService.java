package com.xbrain.application.domain.pedido.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbrain.application.domain.pedido.dao.ProdutoDAO;
import com.xbrain.application.domain.pedido.entity.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoDAO dbProduto;
	
	@Transactional
	public List<Produto> buscarListaProduto() {
		
		return dbProduto.findAll();
	}
}