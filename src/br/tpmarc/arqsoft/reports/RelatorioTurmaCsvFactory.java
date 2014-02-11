package br.tpmarc.arqsoft.reports;

import br.tpmarc.arqsoft.models.Turma;

public class RelatorioTurmaCsvFactory implements RelatorioTurmaFactory {
	
	private static RelatorioTurmaCsvFactory instancia;
	
	private RelatorioTurmaCsvFactory() {
	}

	@Override
	public RelatorioTurma criarRelatorio(Turma turma) {
		return new RelatorioTurmaCsv(turma);
	}
	
	public static RelatorioTurmaCsvFactory getInstancia() {
		if (instancia == null) {
			instancia = new RelatorioTurmaCsvFactory();
		}
		return instancia;
	}

}
