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
    public void eliminarHorario(@PathVariable int id) {
        horarioService.eliminarHorario(id);
    }
    @GetMapping("/tienda/{id}")
    public List<Horario> obtenerHorariosPorTienda(@PathVariable int id) {
        Tienda tienda = new Tienda();
        tienda.setId(id);
        return horarioService.obtenerHorariosPorTienda(tienda);
    }
    @PostMapping("/tienda/{id}")
    public Horario crearHorarioParaTienda(@PathVariable int id, @RequestBody Horario nuevoHorario) {
        Tienda tienda = new Tienda();
        tienda.setId(id);
        nuevoHorario.setTienda(tienda);
        return horarioService.guardarHorario(nuevoHorario);
    }
    @DeleteMapping("/tienda/{id}/horario/{horarioId}")
    public void eliminarHorarioDeTienda(@PathVariable int id, @PathVariable int horarioId) {
        Tienda tienda = new Tienda();
        tienda.setId(id);
        Horario horario = new Horario();
        horario.setId(horarioId);
        horario.setTienda(tienda);
        horarioService.eliminarHorario(horarioId);
    }

}
