package Model;

import java.util.*;

public class Comentario extends Conteudo{
	public Comentario() {
        this.data_publicacaod = Calendar.getInstance();
    }
	
	private int id;
	private String texto;
	private Calendar data_publicacaod; 
	private Conteudo conteudo;
	private Usuario usuario;
	
	public int getIdCm() {
		return id;
	}
	public void setIdCm(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Calendar getData_publicacaod() {
		return data_publicacaod;
	}
	public void setData_publicacaod(Calendar data_publicacaod) {
		this.data_publicacaod = data_publicacaod;
	}
	
	public void setData_publicacaod(int dia, int mes, int ano) {
        this.data_publicacaod.set(ano, mes, dia);
    }
	public Conteudo getConteudo() {
		return conteudo;
	}
	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
