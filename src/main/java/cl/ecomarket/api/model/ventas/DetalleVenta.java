package cl.ecomarket.api.model.ventas;

import com.fasterxml.jackson.annotation.JsonBackReference;

import cl.ecomarket.api.model.inventario.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private Double precioUnitario;
    @Column(nullable = false)
    private Double subtotal;
    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    @JsonBackReference
    private Venta venta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
}
