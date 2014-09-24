package com.rjnmattos.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.rjnmattos.dao.UsuarioDAO;
import com.rjnmattos.model.Usuario;
import com.rjnmattos.util.jpa.Transactional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	
	public List<Usuario> obter() {
		return usuarioDAO.obter();
	}
	
	public List<Usuario> obter(String nome) {
		return usuarioDAO.obter(nome);
	}
	
	@Transactional
	public void salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}
	
}
