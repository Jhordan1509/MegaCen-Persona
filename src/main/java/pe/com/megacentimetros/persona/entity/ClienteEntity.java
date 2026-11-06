package pe.com.megacentimetros.persona.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Entity(name = "ClienteEntity")
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 100)
    private String apellidos;

    @Column(name = "razsoc", length = 150)
    private String razonSocial;

    @Column(name = "numdoc", length = 20, nullable = false, unique = true)
    private String documento;

    @Column(name = "tel", length = 20)
    private String telefono;

    @Column(name = "correo", length = 120, unique = true)
    private String correo;

    @Column(name = "dir", length = 250)
    private String direccion;

    @Column(name = "fecreg", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "codtipd", nullable = false)
    private Long codtipd;

    @Column(name = "codsex")
    private Long codsex;

    @Column(name = "coddis")
    private Long coddis;

    @Column(name = "codtipcli", nullable = false)
    private Long codtipcli;

    @Column(name = "estcli", nullable = false)
    private Boolean estado;

    @Transient
    private Object tipodocumento;

    @Transient
    private Object sexo;

    @Transient
    private Object distrito;

    @Transient
    private Object tipocliente;
}
