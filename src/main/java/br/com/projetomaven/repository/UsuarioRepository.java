package br.com.projetomaven.repository;


import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;
 
import br.com.projetomaven.model.UsuarioModel;
 

@Repository
public class UsuarioRepository {
 
	/**
	 * @PersistenceContext é o local onde ficam armazenados as entidades 
	 * que estão sendo manipuladas pelo EntityManager
	 * 
	 * 
	 *@PersistenceContext(type = PersistenceContextType.EXTENDED) assim o Wildfly vai 
	 *gerenciar	para nos as entidades.
	 * 
	 **/
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
 
 
	/**
	 * 
	 * @param usuarioModel
	 * 
	 * Salva um novo registro
	 * 
	 * O JPA exige um contexto de transação para realizar as alterações, por isso vamos
	 * usar a anotação @javax.transaction.Transactional
	 *  
	 * */
	@javax.transaction.Transactional
	public void Salvar(UsuarioModel usuarioModel){
 
		manager.persist(usuarioModel);		
	}
 
	/**
	 * 
	 * @param usuarioModel
	 * 
	 * Realiza a alteração de um registro
	 */
	@javax.transaction.Transactional
	public void Alterar(UsuarioModel usuarioModel){
 
		manager.merge(usuarioModel);		
	}
 
	/**
	 * 
	 * @param codigo
	 * @return UsuarioModel
	 * 
	 * Consulta um usuário por código
	 */	
	public UsuarioModel ConsultarPorCodigo(int codigo){
 
		return manager.find(UsuarioModel.class, codigo);		
	} 
 
	/**
	 * 
	 * @param codigo
	 * 
	 * Exclui um usuário pelo código
	 */
	@javax.transaction.Transactional
	public void Excluir(int codigo){
 
		UsuarioModel usuarioModel = this.ConsultarPorCodigo(codigo);
 
		manager.remove(usuarioModel);
 
	}
 
	/**
	 * 
	 * @return List<UsuarioModel>
	 * 
	 * Consulta todos os usuários cadastrados no banco de dados
	 */
	public List<UsuarioModel> TodosUsuarios(){
 
		return manager.createQuery("SELECT c FROM UsuarioModel c ORDER BY c.nome ", UsuarioModel.class).getResultList();	
	}
 
}
