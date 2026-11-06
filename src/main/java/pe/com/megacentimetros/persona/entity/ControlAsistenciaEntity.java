package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
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
@Entity(name = "ControlAsistenciaEntity")
@Table(name = "controlasistencia")
public class ControlAsistenciaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codasis")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "horent")
    private LocalTime horaEntrada;

    @Column(name = "horsal")
    private LocalTime horaSalida;

    @Column(name = "sitasis", length = 30, nullable = false)
    private String situacion;

    @Column(name = "obs", length = 250)
    private String observacion;

    @Column(name = "codper", nullable = false)
    private Long codper;

    @Column(name = "estasistencia", nullable = false)
    private Boolean estado;
}
