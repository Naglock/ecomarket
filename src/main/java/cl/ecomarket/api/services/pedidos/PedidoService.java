package cl.ecomarket.api.services.pedidos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ecomarket.api.client.UsuarioClient;
import cl.ecomarket.api.model.pedidos.*;
import cl.ecomarket.api.repository.inventario.ProductoRepository;
import cl.ecomarket.api.repository.pedidos.PedidoRepository;

@Service
public class PedidoService {
    @Autowired    
    private PedidoRepository pedidoRepository;
    @Autowired
    private UsuarioClient usuarioClient;
    @Autowired
    private ProductoRepository productoRepository;

    public Pedido generarPedido(Pedido pedido) {
        // Validar que el id del cliente existe llamando a microservicio gestion de usuarios
        if (!usuarioClient.existeUsuarioId(pedido.getClienteId()).block(null)){
                throw new RuntimeException("El id cliente no existe: " + pedido.getClienteId());
            }
        // Validar que el producto del item existe y tiene stock
        for (ItemPedido item : pedido.getItems()){
            if (!productoRepository.existsById(item.getProducto().getId())){
                throw new RuntimeException("No existe el producto ID: " + item.getProducto().getId());
            } else {
                if (!(productoRepository.findById(item.getProducto().getId()).get().getStock() > item.getProducto().getStock())){
                    throw new RuntimeException("No hay stock suficiente para producto ID: " + item.getProducto().getId());
                }
            }
            item.setPedido(pedido);
        }
        // Crear el pedido
        pedido.setEstado(EstadoPedido.PENDIENTE);
        pedido.setFechaCreacion(LocalDate.now());
        Pedido pedidoGuardado = pedidoRepository.save(pedido);
        return pedidoGuardado;

    }

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }


}
