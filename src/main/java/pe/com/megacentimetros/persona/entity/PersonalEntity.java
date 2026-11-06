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
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PersonalEntity")
@Table(name = "personal")
public class PersonalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codper")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "numdoc", length = 20, nullable = false, unique = true)
    private String documento;

    @Column(name = "tel", length = 20)
    private String telefono;

    @Column(name = "correo", length = 120, unique = true)
    private String correo;

    @Column(name = "dir", length = 250)
    private String direccion;

    @Column(name = "feccont", nullable = false)
    private LocalDate fechaContratacion;

    @Column(name = "rol", length = 80, nullable = false)
    private String rol;

    @Column(name = "codsuc", nullable = false)
    private Long codsuc;

    @Column(name = "codtipd", nullable = false)
    private Long codtipd;

    @Column(name = "codsex")
    private Long codsex;

    @Column(name = "coddis")
    private Long coddis;

    @Column(name = "estper", nullable = false)
    private Boolean estado;

    @Transient
    private Object tipodocumento;

    @Transient
    private Object sexo;

    @Transient
    private Object distrito;
}
