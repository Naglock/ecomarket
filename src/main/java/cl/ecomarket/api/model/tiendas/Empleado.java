package cl.ecomarket.api.model.tiendas;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String telefono;
    private String email;    
    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;
}
