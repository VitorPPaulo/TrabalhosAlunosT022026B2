package Biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Biblioteca.Objetos.Livro;
import Biblioteca.Objetos.Pessoa;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();
		
	
	public static void main(String[] args) {
		popularTabela();
		
		System.out.println("Sistema iniciado!");
		mostrarMenu();
	}
	
	private static void popularTabela() {
		listaUsuarios.add(new Pessoa("João"));
		listaUsuarios.add(new Pessoa("Pedro"));
		listaUsuarios.add(new Pessoa("Paulo"));
		listaLivros.add(new Livro("Harry potter", "Aventura"));
		listaLivros.add(new Livro("Senhor dos aneis", "Fantasia"));
	}

	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("--------------------Selecione uma das opções--------------------");
			System.out.println("1 - Listar livros");
			System.out.println("2 - Cadastrar livro");
			System.out.println("3 - Excluir livro");
			System.out.println("4 - Locar livro");
			System.out.println("5 - Devolver livro");
			System.out.println("6-  Registrar usuario");
			System.out.println("7-  Listar usuarios");
			System.out.println("0 - Saida");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
			}while(escolhaUsuario != 0);
	}
	
	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0: {
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		}
		case 1:{
			listarLivros();
			break;
		}
		case 2:{
			cadastrarLivro();
			break;
		}
		case 3:{
			excluirLivro();
			break;
		}
		case 4:{
			locarLivro();
			break;
		}
		case 5:{
			devolverLivro();
			break;
		}
		case 6:{
			CadastrarUsuario();
			break;
		}
		case 7:{
			listarUsuarios();
			break;
		}
		default:
			System.out.println("Insira um valor valido!");
		}
	}

	private static void devolverLivro() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai devolver o livro");
		int usuario = scan.nextInt()-1;
		scan.nextLine();
		
		if(usuario > listaUsuarios.size() && usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		if(listaUsuarios.get(usuario).getLivrosLocados().size() == 0) {
			System.out.println("Usuário não possui livros locados!");
			return;
		}
		
		System.out.println("Informe o livro que o usuário vai devolver");
		int livro= scan.nextInt()-1;
		scan.nextLine();
		
		if(livro >= listaUsuarios.get(usuario).getLivrosLocados().size() || livro < 0) {
			System.out.println("Informe um livro existente");
		}
		
		listaUsuarios.get(usuario).getLivrosLocados().get(livro).setDataLocacao(null);
		listaUsuarios.get(usuario).getLivrosLocados().remove(livro);
		System.out.println("Livro devolvido com sucesso!");
		
	}

	private static void locarLivro() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai locar o Livro");
		int usuario = scan.nextInt()-1;
		scan.nextLine();
		if(usuario > listaUsuarios.size() && usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		
		if(listaUsuarios.get(usuario).getLivrosLocados().size() == 2) {
			System.out.println("Usuário está com o maximo de livros possiveis! Devolva um para poder locar outro!");
			return;
		}
		
		listarLivros();
		int livro = scan.nextInt()-1;
		scan.nextLine();
		if(livro > listaLivros.size() && livro < 0) {
			System.out.println("Informe um livro valido!");
			return;
		}
		if(listaLivros.get(livro).getDataLocacao() != null) {
			System.out.println("Livro ja está locado!");
			return;
		}
		
		
		listaUsuarios.get(usuario).getLivrosLocados().add(listaLivros.get(livro));
		listaLivros.get(livro).setDataLocacao(new Date());
		System.out.println("Livro locado com sucesso!");
	}

	private static void listarUsuarios() {
		System.out.println("\n--------Lista Usuarios--------");
		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.printf("%d) %s \n", i+1, listaUsuarios.get(i).getNome());
			if(listaUsuarios.get(i).getLivrosLocados().size() != 0) {
				for (int j = 0; j < listaUsuarios.get(i).getLivrosLocados().size(); j++) {
					System.out.printf("  %d) %s - %s\n", j+1, listaUsuarios.get(i).getLivrosLocados().get(j).getNome(),listaUsuarios.get(i).getLivrosLocados().get(j).getGenero());
				}
			}
		}
		System.out.println("");
	}

	private static void CadastrarUsuario() {
		Pessoa usuario = new Pessoa();
		
		System.out.println("Informe o nome do Usuario: ");
		usuario.setNome(scan.nextLine());

		listaUsuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
		
	}

	private static void excluirLivro() {
		if(listaLivros.size() == 0) {
			System.out.println("Não existem livros para excluir!");
			return;
		}
		
		listarLivros();
		System.out.println("Informe o livro a ser excluido: ");
		int escolhaUsuario = scan.nextInt() - 1;
		
		if(escolhaUsuario > listaLivros.size()) {
			System.out.println("Valor inválido!");
			return;
		}
		if(listaLivros.get(escolhaUsuario).getDataLocacao() != null) {
			System.out.println("O livro está locado, portanto não pode ser excluido!");
			return;
		}
		listaLivros.remove(escolhaUsuario);
		System.out.println("Livro removido com sucesso!");
		
		
	}

	private static void listarLivros() {
		System.out.println("\n--------Lista Livros--------");
		for (int i = 0; i < listaLivros.size(); i++) {
			System.out.printf("%d) %s - %s / %s\n", i+1, listaLivros.get(i).getNome(),listaLivros.get(i).getGenero(), listaLivros.get(i).validarDisponibilidade());
		}
		System.out.println("");
		
	}

	private static void cadastrarLivro() {
		Livro livro = new Livro();
		
		System.out.println("Informe o nome do livro: ");
		livro.setNome(scan.nextLine());

		System.out.println("Informe o genero do livro: ");
		livro.setGenero(scan.nextLine());
		
		listaLivros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}
}