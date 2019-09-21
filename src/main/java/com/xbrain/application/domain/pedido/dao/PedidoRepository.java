package com.xbrain.application.domain.pedido.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xbrain.application.domain.pedido.entity.Pedido;
import com.xbrain.application.domain.pedido.entity.PedidoPK;

public interface PedidoRepository extends JpaRepository<Pedido, PedidoPK> {

}
