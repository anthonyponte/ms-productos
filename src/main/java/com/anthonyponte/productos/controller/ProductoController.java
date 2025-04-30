package com.anthonyponte.productos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyponte.productos.model.Producto;
import com.anthonyponte.productos.service.IProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    @Autowired
    private IProductoService service;

    @PostMapping
    public ResponseEntity<Producto> create(@Valid @RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
    }

    @GetMapping
    public List<Producto> readAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> readById(@PathVariable Integer id) {
        return service.findById(id)
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Producto producto) {
        return service.findById(id)
                .map(p -> {
                    boolean hasChanges = false;

                    if (!producto.getNombre().equalsIgnoreCase(p.getNombre())) {
                        p.setNombre(producto.getNombre());
                        hasChanges = true;
                    }

                    if (!producto.getDescripcion().equalsIgnoreCase(p.getDescripcion())) {
                        p.setDescripcion(producto.getDescripcion());
                        hasChanges = true;
                    }

                    if (producto.getPrecio() != p.getPrecio()) {
                        p.setPrecio(producto.getPrecio());
                        hasChanges = true;
                    }

                    if (!hasChanges) {
                        return ResponseEntity.badRequest()
                                .body(Map.of("mensaje",
                                        "No se realizaron cambios: los datos del producto son iguales a los actuales."));
                    }

                    return ResponseEntity.ok(service.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
