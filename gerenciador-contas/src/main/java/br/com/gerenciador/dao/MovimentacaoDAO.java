package br.com.gerenciador.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gerenciador.modelo.Conta;

public class MovimentacaoDAO {

	private EntityManager em;
	
	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}
	
	public Double gastoMedioDaConta(Conta conta) {
		TypedQuery<Double> gastoMedio = em.createQuery("select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                            + " and m.tipoMovimentacao = 'SAIDA'", Double.class);
		gastoMedio.setParameter("pConta", conta);
		
		return gastoMedio.getSingleResult();
	}
	
	public Long totalDeMovimentacoes(Conta conta) {
		TypedQuery<Long> total = em.createNamedQuery("totalDeMovimentacoes", Long.class);
		total.setParameter("pConta", conta);
		return total.getSingleResult();
	}
	
}
