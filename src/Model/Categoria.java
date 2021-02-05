package Model;

public class Categoria extends Usuario{
	
	private int id;
	private String nome;
	private boolean ativo;
	
	public int getIdCg() {
		return id;
	}
	public void setIdCg(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
