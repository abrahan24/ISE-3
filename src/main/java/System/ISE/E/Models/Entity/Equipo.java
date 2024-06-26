package System.ISE.E.Models.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipo")
@Setter
@Getter
public class Equipo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_equipo;
    private String estado;
    private String serie;
    private String marca;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "id_tipoEquipo")
    private TipoEquipo tipoEquipo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo", fetch = FetchType.LAZY)
    private List<DetalleInformeTecnico> detalleInformeTecnicos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo", fetch = FetchType.LAZY)
    private List<DetalleRecepcion> detalleRecepciones;
}
