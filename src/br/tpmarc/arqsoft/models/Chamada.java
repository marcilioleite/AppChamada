package br.tpmarc.arqsoft.models;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDate;

public class Chamada {

	private Aula aula;
	
	private LocalDate data;
	
	private Map<Aluno, Boolean> comparecimentos;

	public Chamada() {
		comparecimentos = new HashMap<Aluno, Boolean>();
	}
	
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Map<Aluno, Boolean> getComparecimentos() {
		return comparecimentos;
	}
	
	public void setComparecimentos(Map<Aluno, Boolean> comparecimentos) {
		this.comparecimentos = comparecimentos;
	}

	public void registrarComparecimento(Aluno a, Boolean presente) {
		comparecimentos.put(a, presente);
	}

}
