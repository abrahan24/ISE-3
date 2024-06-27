package System.ISE.E.Controllers.TecnicoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

import System.ISE.E.Models.Dao.PersonaDao;
import System.ISE.E.Models.Dao.TecnicoDao;
import System.ISE.E.Models.Entity.Persona;
import System.ISE.E.Models.Entity.Tecnico;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class TecnicoController {
    
    @Autowired
    private TecnicoDao tecnicoDao;

    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/tecnicos")
    public String tecnicos(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("usuario") != null) {

            model.addAttribute("tecnicos", tecnicoDao.findAll());

            return "Persona/lista_tecnicos";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping("/tecnico")
    public String tecnico(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("tecnico", new Tecnico());
        return "Content/form_persona :: form_tecnico";
    }

    @PostMapping("/TecnicoF")
    public ResponseEntity<String> TecnicoF(@Validated Persona persona, @Validated Tecnico tecnico) {
        
        if (persona.getId_persona() == null) {
            persona.setEstado("A");
            personaDao.save(persona);
            tecnico.setEstado("A");
            tecnico.setPersona(persona);
            tecnicoDao.save(tecnico);
            return ResponseEntity.ok("1");

        }else  {
            Persona persona2 = personaDao.findById(persona.getId_persona()).orElse(null);
            persona2.setNombres(persona.getNombres());
            persona2.setAp_materno(persona.getAp_materno());
            persona2.setAp_paterno(persona.getAp_paterno());
            persona2.setCi(persona.getCi());
            persona2.setDireccion(persona.getDireccion());
            persona2.setEmail(persona.getEmail());
            personaDao.save(persona2);
            Tecnico tecnico2 = tecnicoDao.findById(tecnico.getId_tecnico()).orElse(null);
            tecnico2.setEspecialidad(tecnico.getEspecialidad());
            tecnico2.setPersona(persona2);
            tecnicoDao.save(tecnico2);
            return ResponseEntity.ok("2");
        }
        
    }
    
    @GetMapping("/editar_tecnico/{id_tecnico}")
    public String editar_tecnico(@PathVariable(name = "id_tecnico")Long id_tecnico,Model model) {
        Tecnico tecnico = tecnicoDao.findById(id_tecnico).orElse(null);
        model.addAttribute("tecnico", tecnico);
        model.addAttribute("persona", tecnico.getPersona());
        return "Content/form_persona :: form_tecnico";
    }
    
    @GetMapping("/eliminar_tecnico/{id_tecnico}")
    @ResponseBody
    public void eliminar_tecnico(@PathVariable(name = "id_tecnico")Long id_tecnico) {

        Tecnico tecnico = tecnicoDao.findById(id_tecnico).orElse(null);
        Persona persona = personaDao.findById(tecnico.getPersona().getId_persona()).orElse(null);
        persona.setEstado("X");
        personaDao.save(persona);
        tecnico.setEstado("X");
        tecnicoDao.save(tecnico);

    }
    
    
}
