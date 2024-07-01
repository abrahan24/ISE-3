package System.ISE.E.Controllers.InformeTecnicoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import System.ISE.E.Models.Dao.TecnicoDao;
import System.ISE.E.Models.Dao.TipoEquipoDao;
import System.ISE.E.Models.Dao.TipoServicioDao;
import System.ISE.E.Models.Entity.InformeTecnico;
import System.ISE.E.Models.Entity.TipoServicio;


@Controller
public class InformeTecnicoController {

    @Autowired
    private TecnicoDao tecnicoDao;

    @Autowired
    private TipoServicioDao tipoServicioDao;

    @GetMapping("/informe")
    public String informe(Model model) {

        model.addAttribute("informe", new InformeTecnico());
        model.addAttribute("tipoServicios", tipoServicioDao.findAll());
        model.addAttribute("tecnicos", tecnicoDao.findAll());
        return "informe_tecnico/informe";
    }
    
}
