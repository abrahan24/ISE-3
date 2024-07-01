package System.ISE.E.Controllers.RecepcionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import System.ISE.E.Models.Dao.PersonaDao;
import System.ISE.E.Models.Dao.RecepcionDado;
import System.ISE.E.Models.Dao.TecnicoDao;
import System.ISE.E.Models.Entity.Persona;
import System.ISE.E.Models.Entity.Recepcion;
import System.ISE.E.Models.Entity.Tecnico;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class RecepcionController {
    
    @Autowired
    private TecnicoDao tecnicoDao;

    @Autowired
    private RecepcionDado recepcionDado;

    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/recepciones")
    public String recepciones(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("usuario") != null) {

            model.addAttribute("recepciones", recepcionDado.findAll());

            return "recepcion/lista_recepciones";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping("/recepcion")
    public String recepcion(Model model) {
       
        model.addAttribute("recepcion", new Recepcion());
        return "Content/form_recepcion :: form_tecnico";
    }

    @PostMapping("/RecepcionF")
    public ResponseEntity<String> RecepcionF(@Validated Recepcion recepcion) {
        
        if (recepcion.getId_recepcion() == null) {
            // recepcion.setEstado("A");
            // personaDao.save(persona);
            // tecnico.setEstado("A");
            // tecnico.setPersona(persona);
            // tecnicoDao.save(tecnico);
            return ResponseEntity.ok("1");

        }else  {
            // Persona persona2 = personaDao.findById(persona.getId_persona()).orElse(null);
            // persona2.setNombres(persona.getNombres());
            // persona2.setAp_materno(persona.getAp_materno());
            // persona2.setAp_paterno(persona.getAp_paterno());
            // persona2.setCi(persona.getCi());
            // persona2.setDireccion(persona.getDireccion());
            // persona2.setEmail(persona.getEmail());
            // personaDao.save(persona2);
            // Tecnico tecnico2 = tecnicoDao.findById(tecnico.getId_tecnico()).orElse(null);
            // tecnico2.setEspecialidad(tecnico.getEspecialidad());
            // tecnico2.setPersona(persona2);
            // tecnicoDao.save(tecnico2);
            return ResponseEntity.ok("2");
        }
        
    }
    
    @GetMapping("/editar_recepcion/{id_recepcion}")
    public String editar_recepcion(@PathVariable(name = "id_tecnico")Long id_tecnico,Model model) {
        Tecnico tecnico = tecnicoDao.findById(id_tecnico).orElse(null);
        model.addAttribute("tecnico", tecnico);
        model.addAttribute("persona", tecnico.getPersona());
        return "Content/form_persona :: form_tecnico";
    }
    
    @GetMapping("/eliminar_recepcion/{id_recepcion}")
    @ResponseBody
    public void eliminar_recepcion(@PathVariable(name = "id_recepcion")Long id_recepcion) {

        // Tecnico tecnico = tecnicoDao.findById(id_tecnico).orElse(null);
        // Persona persona = personaDao.findById(tecnico.getPersona().getId_persona()).orElse(null);
        // persona.setEstado("X");
        // personaDao.save(persona);
        // tecnico.setEstado("X");
        // tecnicoDao.save(tecnico);

    }
    
    
}
