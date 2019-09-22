package com.xbrain.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.application.domain.pedido.entity.Produto;
import com.xbrain.application.domain.pedido.service.ProdutoService;

@RestController
@RequestMapping(value="/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService serviceProduto;
	
	@RequestMapping("/list")
	public ResponseEntity<?> obterListaProduto() {
		
		List<Produto> listaProduto = serviceProduto.buscarListaProduto();
		
		return ResponseEntity.ok().body(listaProduto);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveProduto(@RequestBody String jsonProduto) {
		
		System.out.println(jsonProduto);
		
        serviceProduto.saveProduto(jsonProduto);
		
		return ResponseEntity.ok().body("");
	}
}