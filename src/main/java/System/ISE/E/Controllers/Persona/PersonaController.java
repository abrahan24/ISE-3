package System.ISE.E.Controllers.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import System.ISE.E.Models.Dao.PersonaDao;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PersonaController {
    
    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/persona")
    public String persona(Model model) {
        
        return "Persona/lista_personas";
    }
    
}
