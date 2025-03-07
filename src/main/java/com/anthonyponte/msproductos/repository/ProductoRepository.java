package com.anthonyponte.msproductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anthonyponte.msproductos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
