package cl.ecomarket.api.repository.pedidos;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ecomarket.api.model.pedidos.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
