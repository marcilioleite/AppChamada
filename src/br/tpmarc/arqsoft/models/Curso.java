package br.tpmarc.arqsoft.models;


public class Curso {

	private int id;
	
	private String codigo;
	
	private String nome;

	public Curso() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return String.format("(%s) %s", codigo, nome);
	}
	
}
