package br.com.ufrn.web.exercicio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ufrn.web.exercicio.dao.PessoaDao;
import br.com.ufrn.web.exercicio.dominio.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaBean {

	private Pessoa pessoa;

	private List<Pessoa> pessoas;

	private PessoaDao pessoaDao;

	private boolean isAtualizar;

	public PessoaBean() {
		this.pessoa = new Pessoa();
		this.pessoaDao = new PessoaDao();
		this.pessoas = pessoaDao.listAll();
		this.isAtualizar = false;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public boolean isAtualizar() {
		return isAtualizar;
	}

	public void setAtualizar(boolean isAtualizar) {
		this.isAtualizar = isAtualizar;
	}

	public String cadastrar() {
		if (validate(pessoa)) {
			pessoas = pessoaDao.insert(pessoa);
			pessoa = new Pessoa();
			isAtualizar = false;
		}
		return null;
	}

	public String atualizarPessoa() {
		pessoaDao.update(pessoa);
		isAtualizar = false;
		pessoa = new Pessoa();
		return null;
	}

	public String editar(Pessoa pessoa) {
		this.pessoa = pessoa;
		isAtualizar = true;
		return null;
	}

	public String excluir(Pessoa pessoa) {
		pessoaDao.remove(pessoa);
		pessoa = new Pessoa();
		return null;
	}

	public boolean validate(Pessoa pessoa) {
		if (pessoa.getNome() != null && !pessoa.getNome().isEmpty()) {
			return true;
		}
		return false;
	}

}
