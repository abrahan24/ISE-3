package System.ISE.E.Controllers.TecnicoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import System.ISE.E.Models.Dao.TecnicoDao;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TecnicoController {
    
    @Autowired
    private TecnicoDao tecnicoDao;

    @GetMapping("/tecnicos")
    public String tecnicos(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("usuario") != null) {

            model.addAttribute("tecnicos", tecnicoDao.findAll());

            return "Persona/lista_tecnicos";
        }else{
            return "redirect:/login";
        }
    }
    
}
