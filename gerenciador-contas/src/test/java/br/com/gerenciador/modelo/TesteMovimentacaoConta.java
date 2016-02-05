package br.com.gerenciador.modelo;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.util.JPAUtil;

public class TesteMovimentacaoConta {
	
	private EntityManager em;
	
	@Before
	public void criaEntityManager() {
		em = new JPAUtil().getEntityManager();
	}
	
	@Test
	public void testRelacionamentoManyToOne() {
		Movimentacao movimentacao = em.find(Movimentacao.class, 1);
		System.out.println(movimentacao.getConta().getTitular());
	}

}
