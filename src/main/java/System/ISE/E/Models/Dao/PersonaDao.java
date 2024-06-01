package System.ISE.E.Models.Dao;

import org.springframework.data.repository.CrudRepository;

import System.ISE.E.Models.Entity.Persona;

public interface PersonaDao extends CrudRepository<Persona,Long>{
    
}
