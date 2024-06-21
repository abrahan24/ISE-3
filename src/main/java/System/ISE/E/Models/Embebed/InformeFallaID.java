package System.ISE.E.Models.Embebed;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class InformeFallaID implements Serializable{
    
    private Long informeTecnicoId;
    private Long fallaId;
}
