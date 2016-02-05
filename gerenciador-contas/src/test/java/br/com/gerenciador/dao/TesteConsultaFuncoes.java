package br.com.gerenciador.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.modelo.PopulaBancoParaOsTestes;
import br.com.gerenciador.modelo.imp.Conta;
import br.com.gerenciador.util.JPAUtil;

public class TesteConsultaFuncoes {
	
	private EntityManager em;
	
	@Before
	public void criaEntityManager() {
		em = new JPAUtil().getEntityManagerTest();
		em.getTransaction().begin();
		PopulaBancoParaOsTestes p = new PopulaBancoParaOsTestes(em);
		p.PopulaBanco();
	}
	
	@Test
	public void funcaoCount(){
		Conta conta = em.find(Conta.class, 1);
		Query query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", conta);
		
		Long quantidade = (Long) query.getSingleResult();
		System.out.println("Total de Movimentacoes da Conta: " +conta.getTitular() + " quantidade: " +quantidade);
	}
	
	@Test
	public void funcaoCountSemCast(){
		Conta conta = em.find(Conta.class, 1);
		TypedQuery<Long> query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pConta", Long.class);
		query.setParameter("pConta", conta);
		
		Long quantidade = query.getSingleResult();
		System.out.println("Total de Movimentacoes da Conta: " +conta.getTitular() + " quantidade: " +quantidade);
	}
	
	@Test
	public void funcaoMax(){
		Conta conta = em.find(Conta.class, 1);
		Query query = em.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", conta);
		
		BigDecimal valor = (BigDecimal) query.getSingleResult();
		System.out.println("Maior Transação Realizado por: " + conta.getTitular()+ " no Valor: " + valor);
	}
	
	@Test
	public void funcaoMaxSemCast(){
		Conta conta = em.find(Conta.class, 1);
		TypedQuery<BigDecimal> query = em.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);
		query.setParameter("pConta", conta);
		
		BigDecimal valor = query.getSingleResult();
		System.out.println("Maior Transação Realizado por: " + conta.getTitular()+ " no Valor: " + valor);
	}

}
