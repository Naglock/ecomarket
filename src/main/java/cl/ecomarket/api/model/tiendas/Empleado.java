package cl.ecomarket.api.model.tiendas;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String telefono;
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;
}
