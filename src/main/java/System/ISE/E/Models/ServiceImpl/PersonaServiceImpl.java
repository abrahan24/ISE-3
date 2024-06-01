package System.ISE.E.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import System.ISE.E.Models.Dao.PersonaDao;
import System.ISE.E.Models.Entity.Persona;
import System.ISE.E.Models.Service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    private PersonaDao personaDao;

    @Override
    public List<Persona> findAll() {
        // TODO Auto-generated method stub
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public void save(Persona persona) {
        // TODO Auto-generated method stub
        personaDao.save(persona);
    }

    @Override
    public Persona findOne(Long id) {
        // TODO Auto-generated method stub
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        personaDao.deleteById(id);
    }
    
}
