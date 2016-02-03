package br.com.gerenciador.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import br.com.gerenciador.repositorio.RepositorioDeArquivos;

public class SpringContext {
	
	
	private static GenericApplicationContext ctx;
	private static Object LOCK = new Object();

	public static GenericApplicationContext getContext() {
		if (ctx == null) {
			synchronized (LOCK) {
				ctx = new GenericXmlApplicationContext("applicationContext.xml");
			}
		}
		return ctx;
	}

	static RepositorioDeArquivos buscaRepositorio() {

		GenericApplicationContext ctx = SpringContext.getContext();
		BeanFactory factory = ctx;
		return (RepositorioDeArquivos) factory.getBean("repositorioDeArquivosJdbc"); 
		
	}

}
