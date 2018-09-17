package br.com.curso.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import br.com.curso.hibernate.HibernateUtil;
import org.springframework.stereotype.Service;

@Service
public abstract class DAOImplementacao<T> implements DaoService<T> {

	private Class<T> persitenceClass;
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public DAOImplementacao(Class<T> persistenceClass) {
		super();
		this.persitenceClass = persitenceClass;
	}

	@Override
	public void create(T object) throws Exception {
		sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void destroy(T object) throws Exception {
		sessionFactory.getCurrentSession().delete(object);
	}

	@Override
	public void update(T object) throws Exception {
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void saveOrUpdate(T object) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T object) throws Exception {
		return (T) sessionFactory.getCurrentSession().merge(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(persitenceClass).list();
	}
	
}
