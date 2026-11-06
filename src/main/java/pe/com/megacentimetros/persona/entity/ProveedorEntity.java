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
@Entity(name = "ProveedorEntity")
@Table(name = "proveedor")
public class ProveedorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codprov")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "razsoc", length = 150, nullable = false)
    private String razonSocial;

    @Column(name = "numdoc", length = 20, nullable = false, unique = true)
    private String documento;

    @Column(name = "contacto", length = 120)
    private String contacto;

    @Column(name = "tel", length = 20)
    private String telefono;

    @Column(name = "correo", length = 120)
    private String correo;

    @Column(name = "dir", length = 250)
    private String direccion;

    @Column(name = "fecreg", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "estprov", nullable = false)
    private Boolean estado;
}
