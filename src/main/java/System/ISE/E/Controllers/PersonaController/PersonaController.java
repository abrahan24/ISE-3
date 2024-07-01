package System.ISE.E.Controllers.PersonaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import System.ISE.E.Models.Dao.PersonaDao;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PersonaController {
    
    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/persona")
    public String persona(Model model,HttpServletRequest request) {
        if (request.getSession().getAttribute("usuario") != null) {
            
            return "Persona/lista_personas";
        }else{
            return "redirect:/login";
        }
        
    }
    
}
