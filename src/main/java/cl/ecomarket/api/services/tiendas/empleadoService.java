package cl.ecomarket.api.services.tiendas;
import cl.ecomarket.api.repository.tiendas.empleadoRepository;
import cl.ecomarket.api.model.tiendas.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class empleadoService {
    @Autowired
    private empleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodos(){
        return empleadoRepository.findAll();
    }
    public Empleado guardarEmpleado(Empleado nuevoEmpleado){
        if(empleadoRepository.existsById(nuevoEmpleado.getId())){
            throw new RuntimeException("ya existe un empleado con el ID: " + nuevoEmpleado.getId());
        }
        return empleadoRepository.save(nuevoEmpleado);
    }
    public void eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }
    

}
