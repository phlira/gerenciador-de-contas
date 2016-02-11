package br.com.gerenciador.dao;

import java.util.List;

import br.com.gerenciador.model.Pessoa;

public interface PessoaDAO {

	/**
	 * Lista todas as pessoas cadastradas Utilizar para o modulo Admin apenas.
	 */
	public List<Pessoa> listaTodos();
	
	/**
	 * Busca uma pessoa especifica
	 * 
	 * @param id
	 * @return Pessoa
	 */
	public Pessoa buscaPessoa(Integer id);
	
	/**
	 * Salva Pessoa
	 * @param pessoa
	 */
	public void salvar(Pessoa pessoa);
	
	/**
	 * Edita Pessoa
	 * @param pessoa
	 */
	public void editar(Pessoa pessoa);
	
	/**
	 * Desativa Pessoa
	 * @param pessoa
	 */
	public void desativar(Pessoa pessoa);
	
}
