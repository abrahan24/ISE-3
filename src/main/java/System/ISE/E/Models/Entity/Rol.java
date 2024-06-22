package System.ISE.E.Models.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rol")
@Setter
@Getter
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;
    private String estado;
    private String nom_rol;
    private String descripcion;
    private Date fecha_registro;
    private Date fecha_modificacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.EAGER)
    private List<Menu> menus;
    
}
