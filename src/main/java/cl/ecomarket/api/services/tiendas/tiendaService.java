package cl.ecomarket.api.services.tiendas;

import cl.ecomarket.api.model.tiendas.Tienda;
import cl.ecomarket.api.repository.tiendas.tiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tiendaService {

    @Autowired
    private tiendaRepository tiendaRepository;

    public List<Tienda> obtenerTodas(){
        return tiendaRepository.findAll();
    }

    public Tienda guardarTienda(Tienda nuevaTienda){
        if(tiendaRepository.existsById(nuevaTienda.getId())){
            throw new RuntimeException("ya existe una tienda con el ID: " + nuevaTienda.getId());
        }
        return tiendaRepository.save(nuevaTienda);
    }
    public void eliminarTienda(int id){
        tiendaRepository.deleteById(id);
    }

}
