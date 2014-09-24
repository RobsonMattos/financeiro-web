package com.rjnmattos.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.rjnmattos.model.Usuario;
import com.rjnmattos.service.UsuarioService;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;

	private String confirmarSenha;

	@Inject
	private UsuarioService usuarioService;
	
	private List<Usuario> usuariosFiltrados;
	
	public void salvar() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		if(!usuario.getSenha().equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "A senha nao foi confirmada corretamente!", confirmarSenha);
			facesContext.addMessage(null, facesMessage);
		}
		
		usuarioService.salvar(usuario);
	}
	
	public void pesquisar() {
		if(usuario.getNome() == null || usuario.getNome() == "") {
			usuariosFiltrados =  usuarioService.obter();
		} else {
			usuariosFiltrados =  usuarioService.obter(usuario.getNome());
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
}