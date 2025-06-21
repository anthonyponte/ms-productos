package com.anthonyponte.productos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anthonyponte.productos.model.Producto;
import com.anthonyponte.productos.service.IProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    @Autowired
    private IProductoService service;

    @GetMapping
    public List<Producto> listarProductos() {
        return service.listarProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = service.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        Producto p = service.crearProducto(producto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(p.getId());
        return ResponseEntity.created(uri).body(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarEvento(@PathVariable Long id, @RequestBody Producto producto) {
        Producto p = service.actualizarProducto(id, producto);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public void eliminarProductoPorId(@PathVariable Long id) {
        service.eliminarProductoPorId(id);
    }
}
