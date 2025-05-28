package cl.ecomarket.api.controller.tiendas;


import cl.ecomarket.api.model.tiendas.Tienda;
import cl.ecomarket.api.services.tiendas.tiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tiendas")
public class TiendaController {

    @Autowired
    private tiendaService tiendaService;
    @GetMapping
    public List<Tienda> obtenerTodasLasTiendas(){
        return tiendaService.obtenerTodas();
    }

    @PostMapping
    public Tienda creaTienda(@RequestBody Tienda nuevaTienda) {
        return tiendaService.guardarTienda(nuevaTienda);
    }
    @DeleteMapping("/{id}")
    public void eliminarTienda(@PathVariable Long id) {
        tiendaService.eliminarTienda(id);
    }

}
