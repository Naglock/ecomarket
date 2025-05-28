package cl.ecomarket.api.repository.tiendas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.ecomarket.api.model.tiendas.Empleado;

import java.util.List;
@Repository
public interface empleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByTiendaId(Long tiendaId);
    List<Empleado> findByCargo(String cargo);
    List<Empleado> findByNombreContaining(String nombre);
    List<Empleado> findByApellidoContaining(String apellido);

    
} 
