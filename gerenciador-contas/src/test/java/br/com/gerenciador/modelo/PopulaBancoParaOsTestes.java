package br.com.gerenciador.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.gerenciador.model.TipoMovimentacao;
import br.com.gerenciador.modelo.imp.Conta;
import br.com.gerenciador.modelo.imp.Movimentacao;

public class PopulaBancoParaOsTestes {

	private EntityManager em;

	public PopulaBancoParaOsTestes(EntityManager em) {
		this.em = em;
	}

	public void PopulaBanco() {
		Conta conta = new Conta();
		conta.setAgencia("0606");
		conta.setBanco("Bradesco");
		conta.setNumero("0680240");
		conta.setTitular("Pedro Lira");
		
		Conta conta2 = new Conta();
		conta2.setTitular("Heloisa Soares");
		conta2.setBanco("BRB");
		conta2.setAgencia("043");
		conta2.setNumero("54321");
		
		em.persist(conta);
		System.out.println(conta.getId());
		em.persist(conta2);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("150.9"));

		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("150.9"));

		movimentacao.setConta(conta);
		
		Movimentacao movimentacao3 = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("150.9"));

		movimentacao.setConta(conta);
		
		Movimentacao movimentacao4 = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("150.9"));

		movimentacao.setConta(conta2);
		
		Movimentacao movimentacao5 = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("150.9"));

		movimentacao.setConta(conta2);
		
		Movimentacao movimentacao6 = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("150.9"));

		movimentacao.setConta(conta2);
		
		em.persist(movimentacao);
		em.persist(movimentacao2);
		em.persist(movimentacao3);
		em.persist(movimentacao4);
		em.persist(movimentacao5);
		em.persist(movimentacao6);
		
		em.getTransaction().commit();
	}

}
