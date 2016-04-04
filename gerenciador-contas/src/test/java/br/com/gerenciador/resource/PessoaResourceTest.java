package br.com.gerenciador.resource;

import static junit.framework.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.model.Pessoa;
import br.com.gerenciador.util.JPAUtil;

public class PessoaResourceTest {
	
	private EntityManager em;
	
	@Before
	public void init(){
		em = new JPAUtil().getEntityManagerTest();
		em.getTransaction().begin();
	}
	
	@After
	public void finilize() {
		em.getTransaction().commit();
		em.close();
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void CarregaPessoaTest() {
		Pessoa pessoa = em.find(Pessoa.class, 1);
		assertEquals(pessoa.getFirstName(), "Pedro");
	}

}
