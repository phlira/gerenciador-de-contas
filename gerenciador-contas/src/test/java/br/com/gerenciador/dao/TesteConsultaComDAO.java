package br.com.gerenciador.dao;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.modelo.Conta;
import br.com.gerenciador.util.JPAUtil;

public class TesteConsultaComDAO {

	private EntityManager em;
	private MovimentacaoDAO mDAO;
	
	@Before
	public void criaEntityManager() {
		em = new JPAUtil().getEntityManager();
		mDAO = new MovimentacaoDAO(em);
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
