package System.ISE.E.Models.ServiceImpl;

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
    
}
