package cl.ecomarket.api.repository.tiendas;


import cl.ecomarket.api.model.tiendas.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tiendaRepository extends JpaRepository<Tienda, Integer> {}
