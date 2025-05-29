package cl.ecomarket.api.controller.inventario;

import cl.ecomarket.api.dto.ProductoDTO;
import cl.ecomarket.api.model.inventario.Producto;
import cl.ecomarket.api.model.tiendas.Tienda;
import cl.ecomarket.api.services.inventario.ProductoService;
import cl.ecomarket.api.services.tiendas.tiendaService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/productos")
@RequiredArgsConstructor
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private tiendaService tiendaService;

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
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDTO dto) {
        Optional<Tienda> tienda = tiendaService.obtenerTiendaPorId(dto.tiendaId);
        if (!tienda.isPresent()){
            throw new RuntimeException("No existe Tienda ID: " + dto.tiendaId);
        }
        Producto producto = new Producto();
        producto.setNombre(dto.nombre);
        producto.setDescripcion(dto.descripcion);
        producto.setStock(dto.stock);
        producto.setPrecio(dto.precio);
        producto.setTienda(tienda.get());
        productoService.guardarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
       
    }

}
