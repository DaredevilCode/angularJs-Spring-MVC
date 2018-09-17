package br.com.curso.dao;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DaoService<T> {
	void create(T object) throws Exception;
	
	void destroy(T object) throws Exception;
	
	void update(T object) throws Exception;
	
	void saveOrUpdate(T Object) throws Exception;
	
	T merge(T object) throws Exception;
	
	List<T> list() throws Exception;
}
