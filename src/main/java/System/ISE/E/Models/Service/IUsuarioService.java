package System.ISE.E.Models.Service;

import java.util.List;

import System.ISE.E.Models.Entity.Usuario;

public interface IUsuarioService {
    public List<Usuario> findAll();

	public void save(Usuario usuario);

	public Usuario findOne(Long id_usuario);

	public void delete(Long id);
}
