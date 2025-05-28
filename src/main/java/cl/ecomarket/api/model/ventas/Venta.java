package cl.ecomarket.api.model.ventas;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long clienteId;
    @Column(nullable = false)
    private Double total;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate fecha;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<DetalleVenta> detalles;
    private boolean devuelta = false;
}