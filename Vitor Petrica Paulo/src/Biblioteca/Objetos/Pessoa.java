package Biblioteca.Objetos;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

	private String nome;
	private List<Livro> livroLocados;
	
	public Pessoa() {
		this.livroLocados = new ArrayList<Livro>();
	}

	public Pessoa(String nome) {
		this.nome = nome;
		this.livroLocados = new ArrayList<Livro>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Livro> getLivrosLocados() {
		return livroLocados;
	}
	public void setLivrosLocados(List<Livro> livrosLocados) {
		this.livroLocados = livrosLocados;
	}
}
