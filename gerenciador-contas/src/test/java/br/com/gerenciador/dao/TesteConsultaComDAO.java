package br.com.gerenciador.dao;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.dao.imp.MovimentacaoDAO;
import br.com.gerenciador.modelo.PopulaBancoParaOsTestes;
import br.com.gerenciador.modelo.imp.Conta;
import br.com.gerenciador.util.JPAUtil;

public class TesteConsultaComDAO {

	private EntityManager em;
	private MovimentacaoDAO mDAO;
	
	@Before
	public void criaEntityManager() {
		em = new JPAUtil().getEntityManagerTest();
		em.getTransaction().begin();
		mDAO = new MovimentacaoDAO(em);
		PopulaBancoParaOsTestes p = new PopulaBancoParaOsTestes(em);
		p.PopulaBanco();
	}
	
	@Test
	public void testeConsultaNaDao() {
		Conta conta = new Conta();
		conta.setId(1);
		Double media = mDAO.gastoMedioDaConta(conta);
		System.out.println("Media da Conta:" + media);
	}
	
	@Test
	public void testeConsultaNamedQuery() {
		Conta conta = new Conta();
		conta.setId(1);
		long total = mDAO.totalDeMovimentacoes(conta);
		System.out.println("Media da Conta:" + total);
	}
	
	
}
