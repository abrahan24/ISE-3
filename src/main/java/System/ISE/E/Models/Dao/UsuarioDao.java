package System.ISE.E.Models.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import System.ISE.E.Models.Entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario,Long>{
    
    @Query(value = "SELECT u.* FROM usuario u WHERE u.usuario_nom = ?1 AND u.contrasena = crypt(?2, u.contrasena)", nativeQuery = true)
    public Usuario getUsuario(String usuario,String contrasena);

    @Query(value = "SELECT * FROM listar_usuarios_activos()", nativeQuery = true)
    public List<Usuario> listarUsuariosActivos();

    @Procedure(name = "Usuario.agregarUsuario")
    public void agregarUsuario(String p_usuario_nom, String p_contrasena, String p_estado, Date p_fecha_registro, Date p_fecha_modificacion, Long p_id_persona, Long p_id_rol);

    @Procedure(name = "actualizar_usuario")
    public void actualizarUsuario(
            @Param("p_id_usuario") Long idUsuario,
            @Param("p_usuario_nom") String usuarioNom,
            @Param("p_nueva_contrasena") String nuevaContrasena,
            @Param("p_fecha_modificacion") Date fechaModificacion
    );

    @Procedure(name = "Usuario.actualizar_usuario_sp")
    public void actualizarUsuarioSP(Long p_id_usuario, String p_usuario_nom, String p_nueva_contrasena, Date p_fecha_modificacion);
}
