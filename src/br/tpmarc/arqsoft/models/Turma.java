package br.tpmarc.arqsoft.models;
import java.util.List;


public class Turma {

	private int ano;
	
	private int semestre;
	
	private Curso curso;
	
	private List<Aula> aulas;
	
	private List<Aluno> alunos;
	
	public Turma() {
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%d.%d)", curso.getNome(), ano, semestre);
	}
}
