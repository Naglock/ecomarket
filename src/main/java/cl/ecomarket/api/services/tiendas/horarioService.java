package cl.ecomarket.api.services.tiendas;

import cl.ecomarket.api.model.tiendas.Horario;
import cl.ecomarket.api.model.tiendas.Tienda;
import cl.ecomarket.api.repository.tiendas.horarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class horarioService {
    @Autowired
    private horarioRepository horarioRepository;

    public List<Horario>obtenerTodos(){
        return horarioRepository.findAll();
    }
    public Horario guardarHorario(Horario nuevoHorario){
        if(horarioRepository.existsById(nuevoHorario.getId())){
            throw new RuntimeException("ya existe un horario con el ID: " + nuevoHorario.getId());
        }
        return horarioRepository.save(nuevoHorario);
    }
    public void eliminarHorario(Long id){
        horarioRepository.deleteById(id);
    }
    
    public List<Horario> obtenerHorariosPorTienda(Tienda tienda){
        return horarioRepository.findByTienda(tienda);
    }
    

}
