package com.xbrain.application.domain.pedido.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xbrain.application.domain.pedido.entity.Produto;
import com.xbrain.application.domain.pedido.entity.ProdutoPK;

public interface ProdutoDAO extends JpaRepository<Produto, ProdutoPK> {

}
