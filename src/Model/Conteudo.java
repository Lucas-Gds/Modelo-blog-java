package Model;

import java.util.*;

public class Conteudo extends Categoria{

	private int id;
	private Date data_publicacao;
	private String titulo;
	private String texto;
	private boolean ativo;
	private Categoria categoria;
	private Usuario usuario;
	
	public int getIdCt() {
		return id;
	}
	public void setIdCt(int id) {
		this.id = id;
	}
	public Date getData_publicacao() {
		return data_publicacao;
	}
	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
