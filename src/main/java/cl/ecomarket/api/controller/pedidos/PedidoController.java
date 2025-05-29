package cl.ecomarket.api.controller.pedidos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cl.ecomarket.api.model.pedidos.Pedido;
import cl.ecomarket.api.services.pedidos.PedidoService;

@RestController
@RequestMapping("api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar () {
        return pedidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPorId (@PathVariable Long id) {
        return pedidoService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public Pedido generarPedido (@RequestBody Pedido pedido) {
        return pedidoService.generarPedido(pedido);
    }



}
