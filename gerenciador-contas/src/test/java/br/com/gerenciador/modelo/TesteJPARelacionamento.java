package br.com.gerenciador.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.model.TipoMovimentacao;
import br.com.gerenciador.modelo.imp.Conta;
import br.com.gerenciador.modelo.imp.Movimentacao;
import br.com.gerenciador.util.JPAUtil;

public class TesteJPARelacionamento {

	private EntityManager manager;
	
	@Before
	public void criaConexaoComOBanco() {
		manager = new JPAUtil().getEntityManagerTest();
	}
	
	@Test
	public void testaRelacionamentoContaComMovimentacao() {

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Conta de Luz");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("150.9"));
        
        Conta conta = manager.find(Conta.class, 1);
        
        movimentacao.setConta(conta);

        manager.getTransaction().begin();

        manager.persist(conta);
        manager.persist(movimentacao);

        manager.getTransaction().commit();

        manager.close();		
	}
	
}
