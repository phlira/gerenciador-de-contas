package br.com.gerenciador.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.modelo.imp.Conta;
import br.com.gerenciador.util.JPAUtil;

public class TesteContaMovimentacoes {

	private EntityManager em;
	
	@Before
	public void criaEntityManager() {
		em = new JPAUtil().getEntityManagerTest();
		em.getTransaction().begin();
	}
	
	@After
	public void fechaTransacao(){
		em.close();
	}
	
	@Test
	public void testRelacionamentoOneToMany() {
		PopulaBancoParaOsTestes p = new PopulaBancoParaOsTestes(em);
		p.PopulaBanco();
		Conta contaRetorno = em.find(Conta.class, 1);
		System.out.println(contaRetorno.getTitular());
	}

	@Test
	public void testRelacionamentoOneToManyBidirecional() {
		Query query = em.createQuery("select c from Conta c join fetch c.movimentacoes where c.id= :pId");
		query.setParameter("pId", 1);
		List<Conta> contas = query.getResultList();
		for (Conta conta : contas) {
			System.out.println(conta.getMovimentacoes().size());
		}
		
	}

	
}
