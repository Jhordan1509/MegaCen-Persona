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
@Entity(name = "TransportistaEntity")
@Table(name = "transportista")
public class TransportistaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codtransp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomtransp", length = 120, nullable = false)
    private String nombre;

    @Column(name = "numdoc", length = 20)
    private String documento;

    @Column(name = "tel", length = 20)
    private String telefono;

    @Column(name = "correo", length = 120)
    private String correo;

    @Column(name = "tiptransp", length = 80)
    private String tipo;

    @Column(name = "placa", length = 15)
    private String placa;

    @Column(name = "esttransp", nullable = false)
    private Boolean estado;
}
