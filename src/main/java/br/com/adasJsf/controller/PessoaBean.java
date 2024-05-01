package br.com.adasJsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.adasJsf.model.Pessoa;

@Named("PessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {
// Serial comentado pela interface
	private static final long serialVersionUID = 1L;
//Injeção de dependencia da classe pessoa do pacote model
	@Inject
	private Pessoa pessoa;

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
//Declaração dos metodos da bean
	public String adicionar() {
		pessoas.add(pessoa);
		pessoa = new Pessoa();
		System.out.println("Tamanho da lista: " + this.pessoas.size());
		return null;
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

}
