package System.ISE.E.Controllers.UsuarioController;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import System.ISE.E.Models.Dao.RolDao;
import System.ISE.E.Models.Entity.Persona;
import System.ISE.E.Models.Entity.Rol;
import System.ISE.E.Models.Entity.Tecnico;
import System.ISE.E.Models.Entity.Usuario;
import System.ISE.E.Models.Service.IPersonaService;
import System.ISE.E.Models.Service.IUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private RolDao rolDao;

    @GetMapping("/usuarios")
    public String usuario(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("usuario") != null) {

            model.addAttribute("usuario", usuarioService.listarUsuariosActivos());

            return "Persona/lista_usuarios";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/usuario")
    public String tecnico(Model model) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("personas", personaService.findAll());
        model.addAttribute("roles", rolDao.findAll());

        return "Content/form_usuario :: form_usuario";
    }

    @PostMapping("/UsuarioF")
    public ResponseEntity<String> agregarUsuario(
            @RequestParam(name = "id_usuario", required = false) Long idUsuario,
            @RequestParam(name = "usuario_nom",required = false) String usuarioNom,
            @RequestParam(name = "contrasena", required = false) String contrasena,
            @RequestParam(name = "nueva_contrasena", required = false) String nuevaContrasena,
            @RequestParam(name = "persona", required = false) Long idPersona,
            @RequestParam(name = "rol", required = false) Long idRol) {

            if (idUsuario == null) {
                // Crear nuevo usuario
                System.out.println("1111");
                usuarioService.agregarUsuario(usuarioNom, contrasena, "A", new Date(), new Date(), idPersona, idRol);
                return ResponseEntity.ok("1");
            } else {
                // Actualizar usuario existente con nueva contraseña encriptada
                if (nuevaContrasena != null && !nuevaContrasena.isEmpty()) {
                    System.out.println("222");
                    usuarioService.actualizarUsuario(idUsuario, usuarioNom, nuevaContrasena, new Date());
                } else {
                    return ResponseEntity.ok("3");
                }
            }
            return null;
       
    }


    @GetMapping("/editar_usuario/{id_usuario}")
    public String editar_usuario(@PathVariable(name = "id_usuario") Long id_usuario, Model model) {
        Usuario usuario = usuarioService.findOne(id_usuario);
        model.addAttribute("usuario", usuario);
        // model.addAttribute("personas", personaService.findAll());
        // model.addAttribute("roles", rolDao.findAll());
        return "Content/form_usuario :: form_usuario";
    }

    @GetMapping("/eliminar_usuario/{id_usuario}")
    @ResponseBody
    public void eliminar_tecnico(@PathVariable(name = "id_usuario") Long id_usuario) {

        Usuario usuario = usuarioService.findOne(id_usuario);
        usuario.setEstado("X");
        usuarioService.save(usuario);
    }

}
