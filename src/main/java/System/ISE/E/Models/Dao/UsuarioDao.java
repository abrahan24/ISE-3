package System.ISE.E.Models.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import System.ISE.E.Models.Entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario,Long>{
    
    @Query(value = "SELECT u.* FROM usuario u WHERE u.usuario_nom = ?1 AND u.contrasena = crypt(?2, u.contrasena)", nativeQuery = true)
    public Usuario getUsuario(String usuario,String contrasena);
}
