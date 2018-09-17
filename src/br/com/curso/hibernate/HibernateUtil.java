package br.com.curso.hibernate;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author DareDevilCoder
 * Responsavel por conectar com o Hibernate
 */
public class HibernateUtil implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	/**
	 * Responsavel por ler o arquivo hibernate.cfg.xml
	 * @return SessionFactory 
	 * */
	private static SessionFactory buildSessionFactory() {
		try {
			if(sessionFactory == null) {
				sessionFactory = (new Configuration()).
									configure().
									buildSessionFactory();
			}
			return sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("Erro ao criar conexao com SessionFctory");
		}
	}
	
	/**
	 * Retorna o sessionFactory Corrente
	 * @return SessionFactory
	 * */
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
