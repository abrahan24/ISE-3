package System.ISE.E.Models.ServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import System.ISE.E.Models.Dao.UsuarioDao;
import System.ISE.E.Models.Entity.Usuario;
import System.ISE.E.Models.Service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll() {
        // TODO Auto-generated method stub
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public void save(Usuario usuario) {
        // TODO Auto-generated method stub
        usuarioDao.save(usuario);
    }

    @Override
    public Usuario findOne(Long id_usuario) {
        // TODO Auto-generated method stub
        return usuarioDao.findById(id_usuario).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        usuarioDao.deleteById(id);
    }

    @Override
    public List<Usuario> listarUsuariosActivos() {
        // TODO Auto-generated method stub
        return usuarioDao.listarUsuariosActivos();
    }

    @Override
    public void agregarUsuario(String p_usuario_nom, String p_contrasena, String p_estado, Date p_fecha_registro,
            Date p_fecha_modificacion, Long p_id_persona, Long p_id_rol) {
        // TODO Auto-generated method stub
        usuarioDao.agregarUsuario(p_usuario_nom, p_contrasena, p_estado, p_fecha_registro, p_fecha_modificacion, p_id_persona, p_id_rol);
    }

   

    @Override
    public void actualizarUsuarioSP(Long p_id_usuario, String p_usuario_nom, String p_nueva_contrasena,
            Date p_fecha_modificacion) {
        // TODO Auto-generated method stub
        usuarioDao.actualizarUsuarioSP(p_id_usuario, p_usuario_nom, p_nueva_contrasena, p_fecha_modificacion);
    }

    @Override
    public void actualizarUsuario(Long idUsuario, String usuarioNom, String nuevaContrasena, Date fechaModificacion) {
        // TODO Auto-generated method stub
        usuarioDao.actualizarUsuario(idUsuario, usuarioNom, nuevaContrasena, fechaModificacion);;
    }
    
}
