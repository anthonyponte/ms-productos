package com.anthonyponte.msproductos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyponte.msproductos.model.Producto;
import com.anthonyponte.msproductos.service.IProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final IProductoService service;

    public ProductoController(IProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> getAllClients() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getClientById(@PathVariable Long id) {
        return service.findById(id)
                .map(client -> ResponseEntity.ok(client))
                .orElse(ResponseEntity.notFound().build());
    }
}
