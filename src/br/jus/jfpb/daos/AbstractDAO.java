package br.jus.jfpb.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.jus.jfpb.model.AbstractEntityModel;


public class AbstractDAO<T extends AbstractEntityModel> {
	
	@PersistenceContext
	protected EntityManager manager;
	
	private Class<T> classe;
	
	public AbstractDAO(Class<T> classe) {
		this.classe = classe;
	}

	public void inserir(T entidade) {
		manager.persist(entidade);
	}

	public void atualizar(T entidade) {
		manager.merge(entidade);
	}

	public void excluir(T entidade) {
		entidade = manager.find(classe, entidade.getId());
		manager.remove(entidade);
	}
	
	public T buscarPorID(Long id) {
		return manager.find(classe, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		Query query = manager.createQuery("select e from "+classe.getSimpleName()+" e");
		return query.getResultList();
	}
}

//Desenvolvido por Yuri Santos
