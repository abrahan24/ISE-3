package System.ISE.E.Models.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "submenu")
@Setter
@Getter
public class SubMenu implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_submenu;
    private String nom_subMenu;
    private String estado;
    private String ruta_url;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;
}
