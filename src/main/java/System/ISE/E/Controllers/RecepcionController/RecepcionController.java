package System.ISE.E.Controllers.RecepcionController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import System.ISE.E.Models.Dao.ClienteDao;
import System.ISE.E.Models.Dao.DetalleRecepcionDao;
import System.ISE.E.Models.Dao.EquipoDao;
import System.ISE.E.Models.Dao.PersonaDao;
import System.ISE.E.Models.Dao.RecepcionDado;
import System.ISE.E.Models.Dao.TecnicoDao;
import System.ISE.E.Models.Dao.TipoEquipoDao;
import System.ISE.E.Models.Entity.Cliente;
import System.ISE.E.Models.Entity.DetalleRecepcion;
import System.ISE.E.Models.Entity.Equipo;
import System.ISE.E.Models.Entity.Persona;
import System.ISE.E.Models.Entity.Recepcion;
import System.ISE.E.Models.Entity.Tecnico;
import System.ISE.E.Models.Entity.TipoEquipo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RecepcionController {
    
    @Autowired
    private TecnicoDao tecnicoDao;

    @Autowired
    private RecepcionDado recepcionDado;

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private TipoEquipoDao tipoEquipoDao;

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private EquipoDao equipoDao;

    @Autowired
    private DetalleRecepcionDao detalleRecepcionDao;

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
        model.addAttribute("tecnicos", tecnicoDao.findAll());
        model.addAttribute("persona", new Persona());
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("equipo", new Equipo());
        model.addAttribute("tipoEquipos", tipoEquipoDao.findAll());
        return "Content/form_recepcion :: form_recepcion";
    }

    // @PostMapping("/RecepcionF")
    // public ResponseEntity<String> RecepcionF(@Validated Recepcion recepcion,@Validated Cliente cliente,@Validated Persona persona) {
        

    //     persona.setEstado("A");
    //     personaDao.save(persona);

    //     cliente.setEstado("A");
    //     cliente.setPersona(persona);
    //     clienteDao.save(cliente);

    //     recepcion.setEstado("A");
    //     recepcion.setCliente(cliente);
    //     recepcion.setFecha_recepcion(new Date());

    //     recepcionDado.save(recepcion);

    //     return ResponseEntity.ok("1");

    // }

    @PostMapping(value = "/RecepcionF")
    public ResponseEntity<String> recepcionF(@Valid Recepcion recepcion,
            @Valid Cliente cliente,
            @Valid Persona persona,
            @RequestParam(name = "cant_equipos",required = false) Integer cant_equipos,
            @RequestParam(name = "detalleRecepciones", required = false) List<DetalleRecepcion> detalleRecepciones)
            {

        // Guardar persona y cliente si es necesario
        persona.setEstado("A");
        personaDao.save(persona);

        cliente.setEstado("A");
        cliente.setPersona(persona);
        clienteDao.save(cliente);

        // Asignar cliente a recepcion y guardar recepcion
        recepcion.setEstado("A");
        recepcion.setCliente(cliente);
        recepcion.setFecha_recepcion(new Date());
        recepcionDado.save(recepcion);

        
        // Procesar detalleRecepciones recibidos
        if (detalleRecepciones != null) {
            for (DetalleRecepcion detalleReq : detalleRecepciones) {
                DetalleRecepcion detalleRecepcion = new DetalleRecepcion();
                detalleRecepcion.setRecepcion(recepcion); // Asignar la recepción al detalle
                // Aquí puedes configurar los demás atributos de detalleRecepcion según los datos recibidos

                // Crear o obtener el equipo correspondiente
                Equipo equipo = null;
                if (detalleReq.getEquipo().getId_equipo() != null) {
                    equipo = equipoDao.findById(detalleReq.getEquipo().getId_equipo()).orElse(null);
                }

                if (equipo == null) {
                    // Crear un nuevo equipo si no existe
                    equipo = new Equipo();
                    // Configurar los atributos del equipo según los datos recibidos en detalleReq
                    // Por ejemplo:
                    equipo.setMarca(detalleReq.getEquipo().getMarca());
                    equipo.setModelo(detalleReq.getEquipo().getModelo());
                    equipo.setSerie(detalleReq.getEquipo().getSerie());
                    // Guardar el nuevo equipo en la base de datos
                    equipo = equipoDao.save(equipo);
                }

                // Asignar el equipo al detalle de recepción
                detalleRecepcion.setEquipo(equipo);

                // Guardar el detalleRecepcion en tu servicio/DAO correspondiente
                detalleRecepcionDao.save(detalleRecepcion);
            }
        }

        // for (int i = 0; i < cant_equipos; i++) {
            
        //     Equipo equipo = new Equipo();
            

        //     DetalleRecepcion detalleRecepcion = new DetalleRecepcion();

        // }
        
        return ResponseEntity.ok("1");
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

    @GetMapping("/fallas/{id_tipoEquipo}/{index}")
    public String fallas(@PathVariable(name = "id_tipoEquipo",required = false)Long id_tipoEquipo,
    @PathVariable(name = "index",required = false)Integer index,Model model) {

        TipoEquipo tipoEquipo = tipoEquipoDao.findById(id_tipoEquipo).orElse(null);

        System.out.println(index);
        model.addAttribute("fallas", tipoEquipo.getFallas());
        model.addAttribute("aux", index);

        return "Content/fallas :: fallas";
    }
    
    
    
}
