package System.ISE.E.Models.Service;

import java.util.List;

import System.ISE.E.Models.Entity.Persona;

public interface IPersonaService {
    public List<Persona> findAll();

	public void save(Persona persona);

	public Persona findOne(Long id);

	public void delete(Long id);
}
