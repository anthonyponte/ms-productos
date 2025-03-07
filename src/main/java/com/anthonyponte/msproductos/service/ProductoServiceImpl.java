package com.anthonyponte.msproductos.service;

import java.util.List;
import java.util.Optional;

import com.anthonyponte.msproductos.model.Producto;
import com.anthonyponte.msproductos.repository.ProductoRepository;

public class ProductoServiceImpl implements IProductoService {
    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
