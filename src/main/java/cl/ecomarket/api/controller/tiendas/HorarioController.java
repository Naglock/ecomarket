package cl.ecomarket.api.controller.tiendas;

import cl.ecomarket.api.model.tiendas.Horario;
import cl.ecomarket.api.model.tiendas.Tienda;
import cl.ecomarket.api.services.tiendas.horarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/horarios")
public class HorarioController {
    @Autowired
    private horarioService horarioService;
    @GetMapping
    public List<Horario> obtenerTodosLosHorarios() {
        return horarioService.obtenerTodos();
    }
    @PostMapping
    public Horario crearHorario(@RequestBody Horario nuevoHorario) {
        return horarioService.guardarHorario(nuevoHorario);
    }
    @DeleteMapping("/{id}")
    public void eliminarHorario(@PathVariable Long id) {
        horarioService.eliminarHorario(id);
    }
    @GetMapping("/tienda/{id}")
    public List<Horario> obtenerHorariosPorTienda(@PathVariable Long id) {
        Tienda tienda = new Tienda();
        tienda.setId(id);
        return horarioService.obtenerHorariosPorTienda(tienda);
    }
    @PostMapping("/tienda/{id}")
    public Horario crearHorarioParaTienda(@PathVariable Long id, @RequestBody Horario nuevoHorario) {
        Tienda tienda = new Tienda();
        tienda.setId(id);
        nuevoHorario.setTienda(tienda);
        return horarioService.guardarHorario(nuevoHorario);
    }
    @DeleteMapping("/tienda/{id}/horario/{horarioId}")
    public void eliminarHorarioDeTienda(@PathVariable Long id, @PathVariable Long horarioId) {
        Tienda tienda = new Tienda();
        tienda.setId(id);
        Horario horario = new Horario();
        horario.setId(horarioId);
        horario.setTienda(tienda);
        horarioService.eliminarHorario(horarioId);
    }

}
