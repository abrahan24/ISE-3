package System.ISE.E.Controllers.Inicio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InicioController {
    
    @GetMapping("/inicio")
    public String inicio(Model model , HttpServletRequest request) {

        if (request.getSession().getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        return "Inicio/inicio";
    }

    @GetMapping("/cerrar_sesion")
    public String getMethodName(HttpServletRequest request, RedirectAttributes flash) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
            flash.addAttribute("mensaje", "Se Cerro la Sesion Con Exito");
        }
        return "redirect:/login";
    }
    
    
}
