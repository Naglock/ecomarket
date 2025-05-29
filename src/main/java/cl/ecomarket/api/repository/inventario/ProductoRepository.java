package cl.ecomarket.api.repository.inventario;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ecomarket.api.model.inventario.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}