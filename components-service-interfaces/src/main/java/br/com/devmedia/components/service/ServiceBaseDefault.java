package br.com.devmedia.components.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.components.model.ModelBase;

@Transactional
public abstract class ServiceBaseDefault<T extends ModelBase<?>> implements
		ServiceBase<T> {

	@PersistenceContext
	protected EntityManager em;

	@Override
	@Transactional(readOnly = false)
	public void delete(Object id) throws EntityNotFoundException {

		T entity = this.getById(id);

		if (entity != null)
			em.remove(entity);
		else
			throw new EntityNotFoundException();
	}

	@Override
	@Transactional(readOnly = true)
	public T getById(Object id) throws EntityNotFoundException {

		T entity = em.find(getClassT(), id);

		if (entity == null)
			throw new EntityNotFoundException();
		else
			return entity;
	}

	@Override
	@Transactional(readOnly = false)
	public void save(T entity) {
		Object id = entity.getId();

		if (id == null)
			em.persist(entity);
		else
			em.merge(entity);
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query q = em.createQuery("from " + getClassT().getName() + " t");
		return q.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<T> findByFields(Map<String, Object> fields, Boolean exclusive,
			int maxResults, String orderBy) {

		StringBuilder strbld = new StringBuilder("from "
				+ getClassT().getName() + " t");

		String param = "";
		String connector = " where ";

		if (fields != null) {

			for (String key : fields.keySet()) {

				param = key.replace(".", "");

				if (fields.get(key) instanceof String) {

					String strfld = (String) fields.get(key);

					if (strfld.equals("is null"))
						strbld.append(connector + "t." + key + " is null");
					else if (strfld.equals("is not null"))
						strbld.append(connector + "t." + key + " is not null");
					else if (strfld.startsWith("like "))
						strbld.append(connector + "lower(t." + key
								+ ") like lower(:" + param + ")");
					else if (strfld.startsWith("!= "))
						strbld.append(connector + "t." + key + " != :" + param);
					else
						strbld.append(connector + "t." + key + " = :" + param);

				} else
					strbld.append(connector + "t." + key + " = :" + param);

				if (exclusive)
					connector = " and ";
				else
					connector = " or ";
			}
		}

		if (orderBy != null) {
			if (!"".equals(orderBy.trim())) {
				strbld.append(" order by t." + orderBy);
			}
		}

		Query q = em.createQuery(strbld.toString());
		if (maxResults > 0)
			q.setMaxResults(maxResults);

		param = "";
		for (String key : fields.keySet()) {
			if (!fields.get(key).equals("is null")
					&& !fields.get(key).equals("is not null")) {

				param = key.replace(".", "");

				if (fields.get(key) instanceof String) {

					String strfld = (String) fields.get(key);

					if (strfld.startsWith("like ")) {

						strfld = strfld.replace("like ", "").replace("'", "");
						q.setParameter(param, strfld);

					} else if (strfld.startsWith("!= ")) {

						strfld = strfld.replace("!= ", "");
						q.setParameter(param, strfld);

					} else
						q.setParameter(param, fields.get(key));

				} else
					q.setParameter(param, fields.get(key));
			}
		}

		return (List<T>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getClassT() {

		Type type = getClass().getGenericSuperclass();

		if (type instanceof ParameterizedType) {

			ParameterizedType paramType = (ParameterizedType) type;

			Class<T> tClass = (Class<T>) paramType.getActualTypeArguments()[0];

			return tClass;

		} else {
			return null;
		}
	}
}
