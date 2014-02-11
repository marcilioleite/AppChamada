package br.tpmarc.arqsoft.models;
import org.joda.time.LocalDate;

public class Aluno {

	private String nome;
	
	private String email;
	
	private LocalDate nascimento;
	
	public Aluno() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
