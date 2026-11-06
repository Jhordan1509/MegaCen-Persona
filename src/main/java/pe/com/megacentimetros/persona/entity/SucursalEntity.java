package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "SucursalEntity")
@Table(name = "sucursal")
public class SucursalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codsuc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomsuc", length = 120, nullable = false)
    private String nombre;

    @Column(name = "dir", length = 250, nullable = false)
    private String direccion;

    @Column(name = "tel", length = 20)
    private String telefono;

    @Column(name = "correo", length = 120)
    private String correo;

    @Column(name = "sitsuc", length = 30, nullable = false)
    private String situacion;

    @Column(name = "estsuc", nullable = false)
    private Boolean estado;
}
