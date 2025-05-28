package cl.ecomarket.api.model.inventario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.List;

import cl.ecomarket.api.model.pedidos.ItemPedido;
import cl.ecomarket.api.model.tiendas.Tienda;
import cl.ecomarket.api.model.ventas.DetalleVenta;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    ///GeneratedValue(strategy = GenerationType.IDENTITY) para generar los Id´s de forma automatica y sequencial
    private Long id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tienda_id")
    private Tienda tienda;
    @OneToMany(mappedBy = "producto")
    private List<ItemPedido> itemsPedido;
    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detallesVenta;
}
