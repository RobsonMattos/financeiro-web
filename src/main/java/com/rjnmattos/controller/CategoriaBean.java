package com.rjnmattos.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rjnmattos.model.Categoria;
import com.rjnmattos.model.Usuario;

@Named
@RequestScoped
public class CategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Categoria categoria;

	private List<Usuario> usuarios;
	
	private List<Categoria> categorias;


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
}