package cl.ecomarket.api.services.inventario;

import cl.ecomarket.api.model.inventario.Producto;
import cl.ecomarket.api.repository.inventario.ProductoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public boolean hayStock(Long productoId, int stock) {
        return productoRepository.findById(productoId)
                .map(p -> p.getStock() >= stock)
                .orElse(false);
    }

    public Producto descontarStock(Long productoId, int stock) {
        Producto producto = productoRepository.findById(productoId).orElseThrow();
        if (producto.getStock() < stock) {
            throw new RuntimeException("Stock insuficiente");
        }
        producto.setStock(producto.getStock() - stock);
        return productoRepository.save(producto);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    

}
