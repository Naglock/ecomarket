package cl.ecomarket.api.controller.ventas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.ecomarket.api.model.ventas.Venta;
import cl.ecomarket.api.services.ventas.VentaService;

@RestController
@RequestMapping("api/v1/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/crear")
    public ResponseEntity<Venta> registrarVenta(@RequestBody Venta venta) {
        Venta guardada = ventaService.registrarVenta(venta);
        return ResponseEntity.ok(guardada);
    }

    @GetMapping
    public List<Venta> obtenerTodas() {
        return ventaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerPorId(@PathVariable Long id) {
        Venta venta = ventaService.obtenerPorId(id);
        return venta != null ? ResponseEntity.ok(venta) : ResponseEntity.notFound().build();
    }

    @GetMapping("/clienteId/{clienteId}")
    public List<Venta> obtenerPorCliente(@PathVariable Long clienteId) {
        return ventaService.obtenerPorClienteID(clienteId);
    }

    @GetMapping("/factura/{id}")
    public ResponseEntity<String> generarFactura(@PathVariable Long id) {
        String factura = ventaService.generarFactura(id);
        return factura != null ? ResponseEntity.ok(factura) : ResponseEntity.notFound().build();
    }

    @PutMapping("/devolucion/{id}")
    public ResponseEntity<String> devolverVenta(@PathVariable Long id) {
        boolean devuelta = ventaService.marcarComoDevuelta(id);
        return devuelta ? ResponseEntity.ok("Devolucion hecho correctamente") :
                        ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        try {
            ventaService.eliminarVenta(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
