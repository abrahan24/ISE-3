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
@Table(name = "servicio")
@Setter
@Getter
public class Servicio implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;
    private String nom_servicio;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_tipoEquipo")
    private TipoEquipo tipoEquipo;

    @JsonIgnore
    @ManyToMany(mappedBy = "servicios")
    private Set<DetalleInformeTecnico> detalleInformeTecnicos;
}
