package cl.ecomarket.api.repository.ventas;

import cl.ecomarket.api.model.ventas.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long>{
    List<Venta> findByClienteId(Long clienteId);
}
