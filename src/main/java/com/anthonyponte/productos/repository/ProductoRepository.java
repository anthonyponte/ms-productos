package com.anthonyponte.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anthonyponte.productos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
