/**
 * 
 */
package br.com.curso.listener;

import java.io.Serializable;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author DareDevilCoder
 *
 */
public class ContextLoaderListenerUtils extends org.springframework.web.context.ContextLoaderListener 
                                        implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private static WebApplicationContext getWac() {
		return WebApplicationContextUtils
				.getWebApplicationContext(getCurrentWebApplicationContext().getServletContext());
	}
	
	/**
	 * Retorna um obejeto do contexto Spring de acordo com seu nome
	 * @param idNomeBean
	 * @return Object
	 */
	public static Object getBean(String idNomeBean) {
		return getWac().getBean(idNomeBean);
	}
	
	/**
	 * Retorna um obejeto do contexto Spring de acordo com sua Class
	 * @param idNomeBean
	 * @return Object
	 */
	public static Object getBean(Class<?> classe) {
		return getWac().getBean(classe);
	}
}
