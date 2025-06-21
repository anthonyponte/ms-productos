package com.anthonyponte.productos.service;

import java.util.List;

import com.anthonyponte.productos.model.Producto;

public interface IProductoService {
    List<Producto> listarProductos();

    Producto obtenerProductoPorId(Long id);

    Producto crearProducto(Producto producto);

    Producto actualizarProducto(Long id, Producto producto);

    void eliminarProductoPorId(Long id);
}
