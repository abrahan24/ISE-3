package System.ISE.E.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
