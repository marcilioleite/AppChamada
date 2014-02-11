package br.tpmarc.arqsoft.reports;

import br.tpmarc.arqsoft.models.Turma;

interface RelatorioTurmaFactory {

	RelatorioTurma criarRelatorio(Turma turma);
	
}
