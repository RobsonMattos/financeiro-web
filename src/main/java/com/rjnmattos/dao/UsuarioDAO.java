package com.rjnmattos.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.rjnmattos.model.Situacao;
import com.rjnmattos.model.Usuario;

/**
 * 
 * @author robson.mattos
 * Data: 26/07/2014
 *
 */
public class UsuarioDAO implements Serializable, ICrud<Usuario> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public List<Usuario> obter() {
		try {
			return em.createQuery("from Usuario", Usuario.class).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Usuario> obter(String nome) {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		try {
			listaUsuario = em.createQuery("from Usuario where upper(nome) = :nome", Usuario.class)
					.setParameter("nome", nome.toUpperCase())
					.getResultList();
			
			return listaUsuario;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void salvar(Usuario obj) {
		// em.merge(obj);

		String insertStatement = "insert into usuario (nome, email, login, senha, celular, idioma, situacao) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		Query query = em.createNativeQuery(insertStatement);
		query.setParameter(1, obj.getNome());
		query.setParameter(2, obj.getEmail());
		query.setParameter(3, obj.getLogin());
		query.setParameter(4, obj.getSenha());
		query.setParameter(5, obj.getCelular());
		query.setParameter(6, "pt_BR");
		query.setParameter(7, obj.getSituacao());
		query.executeUpdate();
	}

	public void editar(Usuario obj) {
		em.merge(obj);
	}

	public void excluir(Usuario obj) {
		em.remove(obj);
	}

}