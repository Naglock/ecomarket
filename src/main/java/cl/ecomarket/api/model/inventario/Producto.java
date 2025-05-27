package cl.ecomarket.api.model.inventario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import cl.ecomarket.api.model.tiendas.Tienda;

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
}
