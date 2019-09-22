package com.xbrain.application.domain.pedido.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xbrain.application.domain.pedido.dao.ProdutoRepository;
import com.xbrain.application.domain.pedido.entity.Produto;
import com.xbrain.application.domain.pedido.entity.ProdutoPK;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository dbProduto;
	
	@Transactional
	public List<Produto> buscarListaProduto() {		
		return dbProduto.findAll();
	}
	
	@Transactional
	public Produto saveProduto(String jsonProduto) {
		
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(jsonProduto);
		
		JsonObject jObject = jsonElement.getAsJsonObject();
        Integer idProduto = jObject.get("idProduto").getAsInt();
        String descricao = jObject.get("descricao").getAsString();
                
        Produto produto = new Produto();
        produto.setId(new ProdutoPK());
        
        produto.getId().setIdProduto(idProduto);
        produto.setDescricao(descricao);
		
		return dbProduto.save(produto);
	}
}