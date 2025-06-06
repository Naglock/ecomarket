package cl.ecomarket.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    ///GeneratedValue(strategy = GenerationType.IDENTITY) para generar los Id´s de forma automatica y sequencial
    private int id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;
}
