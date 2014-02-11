package br.tpmarc.arqsoft.reports;

import br.tpmarc.arqsoft.models.Turma;

public class RelatorioTurmaXmlFactory implements RelatorioTurmaFactory {

	private static RelatorioTurmaXmlFactory instancia;
	
	private RelatorioTurmaXmlFactory() {
	}
	
	@Override
	public RelatorioTurma criarRelatorio(Turma turma) {
		return new RelatorioTurmaXml(turma);
	}
	
	public static RelatorioTurmaXmlFactory getInstancia() {
		if (instancia == null) {
			instancia = new RelatorioTurmaXmlFactory();
		}
		return instancia;
	}

}
