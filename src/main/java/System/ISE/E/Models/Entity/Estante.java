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
@Table(name = "estante")
@Setter
@Getter
public class Estante implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estante;
    private String nom_estante;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_almacen")
    private Almacen almacen;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estante", fetch = FetchType.LAZY)
    private List<Pieza> piezas;
}
