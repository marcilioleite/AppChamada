package br.tpmarc.arqsoft.reports;

import br.tpmarc.arqsoft.models.Turma;

public abstract class RelatorioTurma {
	
	private Turma turma;
	
	public RelatorioTurma(Turma turma) {
		this.turma = turma;
	}
	
	public abstract void preparar();
	
	public abstract void escrever();
	
	public void gerarArquivo() {
		preparar();
		escrever();
	}
	
}
