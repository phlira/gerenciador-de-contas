package br.com.gerenciador.modelo;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.com.gerenciador.modelo.imp.Conta;
import br.com.gerenciador.util.JPAUtil;

public class ContaTest {
	
	private EntityManager em;
	
	@Before
	public void criaConexaoComOBanco() {
        em = new JPAUtil().getEntityManagerTest();
	}

	@Test
	public void testeInsertConta() {
		
		double inicio = System.currentTimeMillis();
		
		Conta conta = new Conta();
        conta.setTitular("Heloisa Soares");
        conta.setBanco("BRB");
        conta.setAgencia("043");
        conta.setNumero("54321");

        em.getTransaction().begin();
        
        em.persist(conta);
        
        em.getTransaction().commit();
        em.close();
        
        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	}
	
	@Test
	public void TesteDeEstadoJPA() {
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	@Test
	public void TesteUpdateContaJPA() {
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		System.out.println(conta.getTitular());
		
		conta.setTitular("Pedro Lira");
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
		
	}

}
