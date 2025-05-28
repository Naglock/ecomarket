package cl.ecomarket.api.services.ventas;

import cl.ecomarket.api.model.ventas.Venta;
import cl.ecomarket.api.model.ventas.DetalleVenta;
import cl.ecomarket.api.repository.ventas.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public Venta registrarVenta(Venta venta) {
        double total = 0;

        for (DetalleVenta detalle : venta.getDetalles()) {
            double subtotal = detalle.getPrecioUnitario() * detalle.getCantidad();
            detalle.setSubtotal(subtotal);
            detalle.setVenta(venta);
            total += subtotal;
        }

        venta.setTotal(total);
        return ventaRepository.save(venta);
    }

    public List<Venta> obtenerTodas() {
        return ventaRepository.findAll();
    }

    public Venta obtenerPorId(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public List<Venta> obtenerPorClienteID(Long clienteId) {
        return ventaRepository.findByClienteId(clienteId);
    }

    public String generarFactura(Long id) {
        Venta venta = obtenerPorId(id);
        if (venta == null) return null;
        StringBuilder factura = new StringBuilder();
        factura.append("======FACTURA ====\n");
        factura.append("==================\n");
        factura.append("N° Venta: ").append(venta.getId()).append("\n");
        factura.append("Cliente ID: ").append(venta.getClienteId()).append("\n");
        factura.append("Fecha: ").append(venta.getFecha()).append("\n\n");
        factura.append("==================\n");
        factura.append("Detalle:\n");
        for (DetalleVenta detalle : venta.getDetalles()) {
            factura.append("- Producto ID: ").append(detalle.getId())
                .append(" | Cantidad: ").append(detalle.getCantidad())
                .append(" | Precio Unitario: ").append(detalle.getPrecioUnitario())
                .append(" | Subtotal: ").append(detalle.getSubtotal()).append("\n");
        }
        factura.append("TOTAL: $").append(venta.getTotal()).append("\n");
        factura.append("================");

        return factura.toString();
    }

    public boolean marcarComoDevuelta(Long id) {
        Venta venta = obtenerPorId(id);
        if (venta == null || venta.isDevuelta()) return false;
        venta.setDevuelta(true);
        ventaRepository.save(venta);
        return true;
    }

    public void eliminarVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("La venta con ID " + id + " no existe.");
        }
    }
}
