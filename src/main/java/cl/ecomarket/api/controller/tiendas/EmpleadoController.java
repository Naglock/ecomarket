package cl.ecomarket.api.controller.tiendas;

import cl.ecomarket.api.services.tiendas.empleadoService;
import cl.ecomarket.api.model.tiendas.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private empleadoService empleadoService;
    @GetMapping
    public List<Empleado> obtenerTodosLosEmpleados(){
        return empleadoService.obtenerTodos();
    }
    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado nuevoEmpleado) {
        return empleadoService.guardarEmpleado(nuevoEmpleado);
    }
    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
    }
    
}
