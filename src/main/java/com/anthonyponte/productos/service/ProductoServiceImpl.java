package com.anthonyponte.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.anthonyponte.productos.model.Producto;
import com.anthonyponte.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto p = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        p.setNombre(producto.getNombre());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());

        return repository.save(p);
    }

    @Override
    public void eliminarProductoPorId(Long id) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        repository.delete(producto);
    }
}
