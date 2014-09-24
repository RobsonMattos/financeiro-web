package com.rjnmattos.dao;

import java.util.List;

/**
 * 
 * @author robson.mattos
 * Data: 26/07/2014
 *
 * @param <T>
 */
public interface ICrud<T> {
	
	/**
	 * Obtem todos os registros
	 * @return Lista de tipos
	 */
	List<T> obter();
	
	/**
	 * Salva o objeto passado no parametro
	 * @param obj
	 */
	void salvar(T obj);
	
	/**
	 * Edita o objeto passado no parametro
	 * @param obj
	 */
	void editar(T obj);
	
	/**
	 * Exclui o objeto passado no parametro
	 * @param obj
	 */
	void excluir(T obj);
	
}
