package cl.ecomarket.api.controller;

import cl.ecomarket.api.model.Producto;
import cl.ecomarket.api.services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<Producto> listar() {
        return productoService.listarProductos();
    }

    @GetMapping("/{productoId}/stock")
    public boolean verificarStock(@PathVariable Long productoId, @RequestParam int stock) {
        return productoService.hayStock(productoId, stock);
    }

    @PostMapping("/{productoId}/descontar")
    public Producto descontarStock(@PathVariable Long productoId, @RequestParam int stock) {
        return productoService.descontarStock(productoId, stock);
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }
}
