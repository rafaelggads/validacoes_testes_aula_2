package br.com.devmedia.components.model;

import java.io.Serializable;

public interface ModelBase<T> extends Serializable {

	/**
	 * @return the id
	 */
	T getId();

	/**
	 * @param id
	 *            the id to set
	 */
	void setId(T id);
}