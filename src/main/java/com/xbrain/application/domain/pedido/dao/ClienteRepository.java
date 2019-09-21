package com.xbrain.application.domain.pedido.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xbrain.application.domain.pedido.entity.Cliente;
import com.xbrain.application.domain.pedido.entity.ClientePK;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, ClientePK> {

}