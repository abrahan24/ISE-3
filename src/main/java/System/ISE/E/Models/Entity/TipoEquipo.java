package System.ISE.E.Models.Entity;

import java.io.Serializable;
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
@Table(name = "tipoEquipo")
@Setter
@Getter
public class TipoEquipo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoEquipo;
    private String nom_tipoEquipo;
    private String estado;
    private Date fecha_registro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipo", fetch = FetchType.LAZY)
    private List<Falla> fallas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipo", fetch = FetchType.LAZY)
    private List<Servicio> servicios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipo", fetch = FetchType.LAZY)
    private List<Equipo> equipos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEquipo", fetch = FetchType.LAZY)
    private List<Pieza> piezas;
}
