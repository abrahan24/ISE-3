package System.ISE.E.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "usuario")
@Entity
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String usuario_nom;
    private String contrasena;
    private String estado;
    private Date fecha_registro;
    private Date fecha_modificacion;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
