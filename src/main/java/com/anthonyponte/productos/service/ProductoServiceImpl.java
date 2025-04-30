package com.anthonyponte.productos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthonyponte.productos.model.Producto;
import com.anthonyponte.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
