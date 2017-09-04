package br.com.projetomaven.repository;


import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;
 
import br.com.projetomaven.model.UsuarioModel;
 

@Repository
public class UsuarioRepository {
 
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@javax.transaction.Transactional
	public void Salvar(UsuarioModel usuarioModel){
 
		manager.persist(usuarioModel);		
	}
 
	@javax.transaction.Transactional
	public void Alterar(UsuarioModel usuarioModel){
 
		manager.merge(usuarioModel);		
	}
 
	public UsuarioModel ConsultarPorCodigo(int codigo){
 
		return manager.find(UsuarioModel.class, codigo);		
	} 
 
	@javax.transaction.Transactional
	public void Excluir(int codigo){
 
		UsuarioModel usuarioModel = this.ConsultarPorCodigo(codigo);
 
		manager.remove(usuarioModel);
 
	}

	public List<UsuarioModel> TodosUsuarios(){
 
		return manager.createQuery("SELECT c FROM UsuarioModel c ORDER BY c.nome ", UsuarioModel.class).getResultList();	
	}
 
}
