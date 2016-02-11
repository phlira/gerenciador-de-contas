package br.com.gerenciador.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gerenciador.dao.PessoaDAO;
import br.com.gerenciador.model.Pessoa;

public class PessoaDAOImp implements PessoaDAO {
	
	private EntityManager em;
	
	public PessoaDAOImp(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Pessoa> listaTodos() {
		TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p", Pessoa.class);
		return query.getResultList();
	}

	@Override
	public Pessoa buscaPessoa(Integer id) {
		TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p where p.id = :pId", Pessoa.class);
		return query.getSingleResult();
	}
	
	@Override
	public void salvar(Pessoa pessoa) {
		em.persist(pessoa);
	}

	@Override
	public void editar(Pessoa pessoa) {
		em.find(Pessoa.class,pessoa.getId());
		em.merge(pessoa);
	}

	@Override
	public void desativar(Pessoa pessoa) {
		//Ainda sem utilizar, criar campo ativo no usuario
	}

}
