package AttPOO.Objetos;

public class Jogo {

	private String nome;
	private int ID;
	private String genero;

    public Jogo() {
    }

	public Jogo(String nome, int ID, String genero) {
        this.ID = ID;
		this.nome = nome;
        this.genero = genero;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}