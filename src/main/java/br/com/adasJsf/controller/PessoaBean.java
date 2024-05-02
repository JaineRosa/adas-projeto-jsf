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
	private int idSequencia= 1;

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
//Declaração dos metodos da bean
	public String adicionar() {
		pessoa.setId(this.getSequenciaId());
		pessoas.add(pessoa);
		pessoa = new Pessoa();
		
		
		return null;
	}
	
	
	private int getSequenciaId(){
		return this.idSequencia++;	 
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
