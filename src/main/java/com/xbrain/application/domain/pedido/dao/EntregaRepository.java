package com.xbrain.application.domain.pedido.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xbrain.application.domain.pedido.entity.Entrega;
import com.xbrain.application.domain.pedido.entity.EntregaPK;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, EntregaPK> {

}