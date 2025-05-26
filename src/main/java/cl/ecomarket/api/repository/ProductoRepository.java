package cl.ecomarket.api.repository;

import cl.ecomarket.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}
