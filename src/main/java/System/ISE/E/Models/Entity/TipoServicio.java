package System.ISE.E.Models.Entity;

import java.io.Serializable;
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
@Table(name = "tipoServicio")
@Setter
@Getter
public class TipoServicio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoServicio;
    private String nom_TipoServicio;
    private String estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoServicio", fetch = FetchType.LAZY)
    private List<InformeTecnico> informeTecnicos;
}
