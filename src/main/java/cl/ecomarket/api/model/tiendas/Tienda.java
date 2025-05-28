package cl.ecomarket.api.model.tiendas;

import cl.ecomarket.api.model.inventario.Producto;
import lombok.Data;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empleado> empleados;
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Horario> horarios;
    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Producto> productos;

}
