package System.ISE.E.Controllers.LoginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import System.ISE.E.Models.Dao.UsuarioDao;
import System.ISE.E.Models.Entity.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UsuarioDao usuarioDao;

    @GetMapping("/login")
    public String login() {

        return "Login/login";
    }

    @PostMapping("/login_form")
    public String login_form(@RequestParam(name = "user") String user,
            @RequestParam(name = "contrasena") String contrasena,HttpServletRequest request) {

        Usuario usuario = usuarioDao.getUsuario(user, contrasena);

        if (usuario != null) {
            if (usuario.getEstado().equals("X")) {
                return "redirect:/login";
            }
            HttpSession session = request.getSession(true);

            session.setAttribute("usuario", usuario);
            session.setAttribute("persona", usuario.getPersona());
            session.setAttribute("rol", usuario.getRol());
            return "redirect:/inicio";
        }else{


        }

        return "entity";
    }

}
