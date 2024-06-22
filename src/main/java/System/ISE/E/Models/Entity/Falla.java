package System.ISE.E.Models.Entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "falla")
@Setter
@Getter
public class Falla implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_falla;
    private String nom_falla;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_tipoEquipo")
    private TipoEquipo tipoEquipo;

    @JsonIgnore
    @ManyToMany(mappedBy = "fallas")
    private Set<DetalleInformeTecnico> detalleInformeTecnicos;

    @JsonIgnore
    @ManyToMany(mappedBy = "fallas")
    private Set<DetalleRecepcion> detalleRecepciones;
}
