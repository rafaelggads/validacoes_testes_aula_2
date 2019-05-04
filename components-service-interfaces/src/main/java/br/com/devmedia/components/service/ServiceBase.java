package br.com.devmedia.components.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import br.com.devmedia.components.model.ModelBase;

public interface ServiceBase<T extends ModelBase<?>> {

	/**
	 * Gravar uma nova instância ou atualizar uma existente no repositorio
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * Excluir uma instância a partir do seu id
	 * 
	 * @param id
	 * @throws EntityNotFoundException
	 */
	void delete(Object id) throws EntityNotFoundException;

	/**
	 * Busca um objeto pelo seu ID no repositorio
	 * 
	 * @param id
	 * @return T entity
	 * @throws EntityNotFoundException
	 */
	T getById(Object id) throws EntityNotFoundException;

	/**
	 * Retorna a lista de todos os objetos do repositorio
	 * 
	 * @return List<T>
	 */
	List<T> findAll();

	/**
	 * Busca a entidade pelos atributos enviados como parametro, até o limite
	 * enviado pelo maxResults e ordenado pelo parametro orderby
	 * 
	 * @param fields
	 *            - Map contendo o nome do atributo e o valor do atributo a ser
	 *            comparado
	 * @param exclusive
	 *            - true para usar AND na query, false para usar OR
	 * @param maxResults
	 *            - máximo de resultados a serem retornados
	 * @param orderBy
	 *            - define o campo que será usado para ordenação dos resultados,
	 *            ex.: 'name DESC', 'codigo', etc.
	 * @return List<T>
	 */
	List<T> findByFields(Map<String, Object> fields, Boolean exclusive,
			int maxResults, String orderBy);
}
