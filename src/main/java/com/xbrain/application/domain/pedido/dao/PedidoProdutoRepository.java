package com.xbrain.application.domain.pedido.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xbrain.application.domain.pedido.entity.PedidoProduto;
import com.xbrain.application.domain.pedido.entity.PedidoProdutoPK;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, PedidoProdutoPK> {

}