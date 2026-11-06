package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
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
@Entity(name = "CapacitacionPersonalEntity")
@Table(name = "capacitacionpersonal")
public class CapacitacionPersonalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcap")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomcap", length = 150, nullable = false)
    private String nombre;

    @Column(name = "descrip", length = 300)
    private String descripcion;

    @Column(name = "fecini", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecfin")
    private LocalDate fechaFin;

    @Column(name = "instit", length = 150)
    private String institucion;

    @Column(name = "codper", nullable = false)
    private Long codper;

    @Column(name = "estcap", nullable = false)
    private Boolean estado;
}
