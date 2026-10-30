package AttPOO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import AttPOO.Objetos.Jogo;

public class Principal {

    static Scanner scan = new Scanner(System.in);
	static List<Jogo> listaJogos = new ArrayList<Jogo>();
	public static void main(String[] args) {
		popularTabela();
		
		System.out.println("Sistema iniciado!");
		mostrarMenu();
	}
	
	private static void popularTabela() {
		listaJogos.add(new Jogo("God of War", 1, "Ação"));
		listaJogos.add(new Jogo("The Last of Us", 2, "Aventura"));
		listaJogos.add(new Jogo("Red Dead Redemption", 3, "Tiro"));
	}

	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("--------------------Selecione uma das opções--------------------");
			System.out.println("1 - Cadastrar jogo");
			System.out.println("2 - Listar jogos");
			System.out.println("3 - Buscar Por ID");
			System.out.println("4 - Atualizar");
			System.out.println("5 - Excluir");
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
			cadastrarJogo();
			break;
		}
		case 2:{
			listarJogos();
			break;
		}
		case 3:{
		buscarPorID();
		break;
		}
        case 4:{
            atualizar();
            break;
        }
		case 5:{
			excluir();
			break;
		}
		default:
			System.out.println("Insira um valor valido!");
		}
	}

private static void excluir() {
        System.out.println("Informe o ID do jogo que deseja excluir: ");
        int id = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < listaJogos.size(); i++) {
            if (listaJogos.get(i).getID() == id) {
                listaJogos.remove(i);
                System.out.println("Jogo excluido com sucesso!");
                return;
            }
        }
        System.out.println("Jogo não encontrado!");
    }

private static void atualizar() {
        System.out.println("Informe o ID do jogo que deseja atualizar: ");
        int id = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < listaJogos.size(); i++) {
            if (listaJogos.get(i).getID() == id) {
                System.out.println("Informe o novo nome do jogo: ");
                String novoNome = scan.nextLine();
                listaJogos.get(i).setNome(novoNome);
                System.out.println("Informe o novo genero do jogo: ");
                String novoGenero = scan.nextLine();
                listaJogos.get(i).setGenero(novoGenero);
                System.out.println("Jogo atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Jogo não encontrado!");
    }

private static void buscarPorID() {
        System.out.println("Informe o ID do jogo que deseja buscar: ");
        int id = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < listaJogos.size(); i++) {
            if (listaJogos.get(i).getID() == id) {
                System.out.printf("Jogo encontrado: %s - %s\n", listaJogos.get(i).getNome(), listaJogos.get(i).getGenero());
                return;
            }
        }
        System.out.println("Jogo não encontrado!");
    }

private static void listarJogos() {
		System.out.println("\n--------Lista Jogos--------");
		for (int i = 0; i < listaJogos.size(); i++) {
			System.out.printf("%d) %s - %s\n", i+1, listaJogos.get(i).getNome(), listaJogos.get(i).getGenero());
		}
		System.out.println("");
	}
private static void cadastrarJogo() {
	Jogo jogo = new Jogo();
		
    int novoId = 1;
    for (int i = 0; i < listaJogos.size(); i++) {
        if (listaJogos.get(i).getID() >= novoId) {
            novoId = listaJogos.get(i).getID() + 1;
        }
    }
    jogo.setID(novoId);
		System.out.println("Informe o nome do jogo: ");
		jogo.setNome(scan.nextLine());

        if (jogo.getNome().isEmpty()) {
            System.out.println("Nome inválido! O nome não pode ser vazio.");
            return;
        } for (int i = 0; i < listaJogos.size(); i++) {
            if (jogo.getNome().equalsIgnoreCase(listaJogos.get(i).getNome())) {
                System.out.println("Nome já cadastrado! Informe um nome diferente.");
                return;
            }
        }
		System.out.println("Informe o genero do jogo: ");
		jogo.setGenero(scan.nextLine());

		listaJogos.add(jogo);
		System.out.println("Jogo cadastrado com sucesso!");
	}
}