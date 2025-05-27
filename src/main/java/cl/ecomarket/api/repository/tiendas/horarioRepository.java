package cl.ecomarket.api.repository.tiendas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.ecomarket.api.model.tiendas.Horario;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
@Repository
public interface horarioRepository extends JpaRepository<Horario, Integer> {
    List<Horario> findByTiendaId(int tiendaId);
    List<Horario> findByDia(DayOfWeek dia);
    List<Horario> findByHoraAperturaBetween(LocalTime horaInicio, LocalTime horaFin);
    List<Horario> findByHoraCierreBetween(LocalTime horaInicio, LocalTime horaFin);

    
} 
