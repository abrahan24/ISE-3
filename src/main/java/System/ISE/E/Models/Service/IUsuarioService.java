package System.ISE.E.Models.Service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import System.ISE.E.Models.Entity.Usuario;

public interface IUsuarioService {
    public List<Usuario> findAll();

	public void save(Usuario usuario);

	public Usuario findOne(Long id_usuario);

	public void delete(Long id);

	public List<Usuario> listarUsuariosActivos();

	public void agregarUsuario(String p_usuario_nom, String p_contrasena, String p_estado, Date p_fecha_registro, Date p_fecha_modificacion, Long p_id_persona, Long p_id_rol);

	public void actualizarUsuario(
            @Param("p_id_usuario") Long idUsuario,
            @Param("p_usuario_nom") String usuarioNom,
            @Param("p_nueva_contrasena") String nuevaContrasena,
            @Param("p_fecha_modificacion") Date fechaModificacion
    );

	public void actualizarUsuarioSP(Long p_id_usuario, String p_usuario_nom, String p_nueva_contrasena, Date p_fecha_modificacion);

}
