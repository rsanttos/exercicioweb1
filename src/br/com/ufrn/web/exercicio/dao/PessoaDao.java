package br.com.ufrn.web.exercicio.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.web.exercicio.dominio.Pessoa;

public class PessoaDao {

	private List<Pessoa> pessoas;
	
	public PessoaDao() {
		if(pessoas == null) {
			this.pessoas = new ArrayList<Pessoa>();
		}
	}
	
	public List<Pessoa> insert(Pessoa pessoa) {
		Pessoa p = new Pessoa();
		p.setCpf(pessoa.getCpf());
		p.setNome(pessoa.getNome());
		p.setTelefone(pessoa.getTelefone());
		this.pessoas.add(p);
		return this.pessoas;
	}
	
	public void remove(Pessoa pessoa) {
		this.pessoas.remove(pessoa);
	}
	
	public void update(Pessoa pessoa) {
		this.pessoas.remove(pessoa);
		this.pessoas.add(pessoa);
	}
	
	public List<Pessoa> listAll(){
		return this.pessoas;
	}
	
}
