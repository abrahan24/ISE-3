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
@Table(name = "detalleRecepcion")
@Setter
@Getter
public class DetalleRecepcion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalleRecepcion;
    
    @ManyToOne
    @JoinColumn(name = "id_recepcion")
    private Recepcion recepcion;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "recepcion_fallas", joinColumns = @JoinColumn(name = "id_detalleRecepcion"), inverseJoinColumns = @JoinColumn(name = "id_falla"))
    private Set<Falla> fallas;
    
}
