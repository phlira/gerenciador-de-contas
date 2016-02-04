package br.com.gerenciador.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.util.JPAUtil;

public class TesteJPARelacionamento {

	private EntityManager manager;
	
	@Before
	public void criaConexaoComOBanco() {
		manager = new JPAUtil().getEntityManager();
	}
	
	@Test
	public void testaRelacionamentoContaComMovimentacao() {

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Fraldas");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("50.9"));
        
        Conta conta = manager.find(Conta.class, 202);
        
        movimentacao.setConta(conta);

        manager.getTransaction().begin();

        manager.persist(conta);
        manager.persist(movimentacao);

        manager.getTransaction().commit();

        manager.close();		
	}
	
}
