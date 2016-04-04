package br.com.gerenciador.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimentacao {
	
	public Movimentacao(TipoMovimentacao tipoMovimentacao, BigDecimal valor, Calendar data) {
//		this.pessoa = pessoa;
//		this.banco = banco;
		this.tipoMovimentacao = tipoMovimentacao;
		this.valor = valor;
		this.data = data;
		
	}
	
	public Movimentacao() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Pessoa pessoa;
	@ManyToOne
	private Banco banco;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	private BigDecimal valor;

	@Temporal(TemporalType.DATE)
	private Calendar data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Pessoa getPessoa() {
//		return pessoa;
//	}
//
//	public void setPessoa(Pessoa pessoa) {
//		this.pessoa = pessoa;
//	}
//
//	public Banco getBanco() {
//		return banco;
//	}
//
//	public void setBanco(Banco banco) {
//		this.banco = banco;
//	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((banco == null) ? 0 : banco.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((tipoMovimentacao == null) ? 0 : tipoMovimentacao.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
//		if (banco == null) {
//			if (other.banco != null)
//				return false;
//		} else if (!banco.equals(other.banco))
//			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
//		if (pessoa == null) {
//			if (other.pessoa != null)
//				return false;
//		} else if (!pessoa.equals(other.pessoa))
//			return false;
		if (tipoMovimentacao != other.tipoMovimentacao)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
