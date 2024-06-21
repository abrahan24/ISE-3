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
@Table(name = "proveedor")
@Setter
@Getter
public class Proveedor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;
    private String estado;
    private String nom_proveedor;
    private String direccion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor", fetch = FetchType.LAZY)
    private List<Pieza> piezas;
}
