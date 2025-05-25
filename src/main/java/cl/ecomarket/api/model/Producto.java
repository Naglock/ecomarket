package cl.ecomarket.api.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;
}
