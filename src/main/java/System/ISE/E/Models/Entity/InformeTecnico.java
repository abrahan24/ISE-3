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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "informeTecnico", fetch = FetchType.LAZY)
    private List<DetalleInformeTecnico> detalleInformeTecnicos;

}
