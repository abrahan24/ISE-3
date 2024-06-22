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
@Table(name = "menu")
@Setter
@Getter
public class Menu implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_menu;
    private String estado;
    private String nom_menu;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu", fetch = FetchType.EAGER)
    private List<SubMenu> subMenus;

}
