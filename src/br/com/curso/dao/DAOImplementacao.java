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
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void destroy(T object) throws Exception {
		sessionFactory.getCurrentSession().delete(object);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void update(T object) throws Exception {
		sessionFactory.getCurrentSession().update(object);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void saveOrUpdate(T object) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(object);
		sessionFactory.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T object) throws Exception {
		T t = (T) sessionFactory.getCurrentSession().merge(object);
		sessionFactory.getCurrentSession().flush();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(persitenceClass).list();
	}
	
}
