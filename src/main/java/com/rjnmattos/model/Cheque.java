package com.rjnmattos.model;

import java.io.Serializable;
import java.util.Date;

public class Cheque implements Serializable {

	private static final long serialVersionUID = 1L;

	private ChequeId chequeId;
	private Conta conta;
	private Date dataCadastro;
	private Character situacao;
	private Lancamento lancamento;

	public ChequeId getChequeId() {
		return chequeId;
	}

	public void setChequeId(ChequeId chequeId) {
		this.chequeId = chequeId;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Character getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((chequeId == null) ? 0 : chequeId.hashCode());
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
		Cheque other = (Cheque) obj;
		if (chequeId == null) {
			if (other.chequeId != null)
				return false;
		} else if (!chequeId.equals(other.chequeId))
			return false;
		return true;
	}
}
