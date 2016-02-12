package br.com.gerenciador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.modelo.imp.Conta;
import br.com.gerenciador.modelo.imp.Movimentacao;
import br.com.gerenciador.modelo.imp.TipoMovimentacao;
import br.com.gerenciador.util.JPAUtil;

public class ConsultaTest {
	
	private EntityManager em;
	
	@Before
	public void criaEntityManager() {
		em = new JPAUtil().getEntityManagerTest();
	}
	
	@Test
	public void testeConsultaComJPQLConcatenandoStrings() {
		Conta conta = new Conta();
		conta.setId(1);
		
		Query query = em.createQuery("select m from Movimentacao m where m.conta.id=" + conta.getId());
		
		@SuppressWarnings("unchecked")
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao m : movimentacoes) {
			System.out.println("\nDescricao ..: " + m.getDescricao());
			System.out.println("Valor ......: R$ " + m.getValor());
		}
		
		em.close();
	}
	
	@Test
	public void testeConsultaComJPQLPositionalParameterNotation() {
		Conta conta = new Conta();
		conta.setId(1);
		
		Query query = em.createQuery("select m "
									 +" from Movimentacao m "
									+" where m.conta=?1"
									+"   and m.tipoMovimentacao=?2");
		query.setParameter(1, conta);
		query.setParameter(2, TipoMovimentacao.SAIDA);
		
		@SuppressWarnings("unchecked")
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao m : movimentacoes) {
			System.out.println("\nDescricao ..: " + m.getDescricao());
			System.out.println("Valor ......: R$ " + m.getValor());
		}
		
		em.close();
	}
	
	@Test
	public void testeConsultaComJPQLNamedParameterNotation() {
		Conta conta = new Conta();
		conta.setId(1);
		
		Query query = em.createQuery("select m "
									 +" from Movimentacao m "
									+" where m.conta= :pConta"
									+"   and m.tipoMovimentacao= :pTipo"
									+" order by m.valor desc");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		@SuppressWarnings("unchecked")
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao m : movimentacoes) {
			System.out.println("\nDescricao ..: " + m.getDescricao());
			System.out.println("Valor ......: R$ " + m.getValor());
		}
		
		em.close();
	}

}
