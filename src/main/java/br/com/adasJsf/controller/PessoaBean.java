package br.com.adasJsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
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
				
		return "/pessoa/listar.xhtml";
	}
	
	
	public String apagar(Pessoa pessoaExcluir) {
		boolean remover=pessoas.remove(pessoaExcluir);
		
		if (remover) {
	        System.out.println("Pessoa removida com sucesso.");
	    } else {
	        System.out.println("Erro ao remover a pessoa.");
	    }
		
		return "/pessoa/listar.xhtml";
		
		
	}
	
	public String editar() {
		int index = pessoas.indexOf(pessoa);
		Pessoa pessoaEdicao = pessoa;
		
		pessoas.remove(pessoa);
		pessoas.add(index, pessoaEdicao);
		
		pessoa = new Pessoa();
		
		return "/pessoa/listar.xhtml";
		
		//alternativa de uso para edição da lista
		// pessoas.set(index , pessoaEdição)
	}
	
	public String telaEdicao() {
		return "/pessoa/editar.xhtml";
	}
	
	public void carregarEdicao(ActionEvent event) {
		Pessoa dadosPessoa = (Pessoa)event.getComponent().getAttributes().get("pessoa");
		
		pessoa.setId(dadosPessoa.getId());
		pessoa.setNome(dadosPessoa.getNome());
		pessoa.setProfissao(dadosPessoa.getProfissao());
		pessoa.setIdade(dadosPessoa.getIdade());
		pessoa.setCidade(dadosPessoa.getCidade());
			
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
