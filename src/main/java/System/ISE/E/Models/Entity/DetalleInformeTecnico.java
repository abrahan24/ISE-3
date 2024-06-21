package System.ISE.E.Models.Entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalleInformeTecnico")
@Setter
@Getter
public class DetalleInformeTecnico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalleInformeTecnico;
    
    @ManyToOne
    @JoinColumn(name = "id_informeTecnico")
    private InformeTecnico informeTecnico;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "detalle_fallas", joinColumns = @JoinColumn(name = "id_detalleInformeTecnico"), inverseJoinColumns = @JoinColumn(name = "id_falla"))
    private Set<Falla> fallas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "detalle_servicios", joinColumns = @JoinColumn(name = "id_detalleInformeTecnico"), inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private Set<Servicio> servicios;
}
