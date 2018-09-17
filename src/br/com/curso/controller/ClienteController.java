package br.com.curso.controller;

import org.springframework.stereotype.Controller;

import br.com.curso.dao.DAOImplementacao;
import br.com.curso.dao.DaoService;
import br.com.curso.models.Cliente;

/**
 * @author DareDevilCoder
 *
 */
@Controller
public class ClienteController extends DAOImplementacao<Cliente> implements DaoService<Cliente> {

	public ClienteController(Class<Cliente> persistenceClass) {
		super(persistenceClass);
	}

}
