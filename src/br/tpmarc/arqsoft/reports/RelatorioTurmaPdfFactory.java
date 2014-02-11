package br.tpmarc.arqsoft.reports;

import br.tpmarc.arqsoft.models.Turma;

public class RelatorioTurmaPdfFactory implements RelatorioTurmaFactory {

	private static RelatorioTurmaPdfFactory instancia;
	
	private RelatorioTurmaPdfFactory() {
	}
	
	@Override
	public RelatorioTurma criarRelatorio(Turma turma) {
		return new RelatorioTurmaPdf(turma);
	}

	public static RelatorioTurmaPdfFactory getInstancia() {
		if (instancia == null) {
			instancia = new RelatorioTurmaPdfFactory();
		}
		return instancia;
	}
	
}
