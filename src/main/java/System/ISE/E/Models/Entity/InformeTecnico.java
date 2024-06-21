package System.ISE.E.Models.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "informe_tecnico")
@Setter
@Getter
public class InformeTecnico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_informeTecnico;
    private String estado;
    private Date fecha_informe;
    private Date fecha_modificacion;
    private String observacion;
    private String recomendacion;
    private String conclucion;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "id_tipoServicio")
    private TipoServicio tipoServicio;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "informe_fallas", joinColumns = @JoinColumn(name = "id_informeTecnico"), inverseJoinColumns = @JoinColumn(name = "id_falla"))
    private Set<Falla> fallas;
    
}
