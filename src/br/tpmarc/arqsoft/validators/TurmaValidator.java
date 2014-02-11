package br.tpmarc.arqsoft.validators;

import org.joda.time.DateTime;

import br.tpmarc.arqsoft.exceptions.InvalidFieldException;
import br.tpmarc.arqsoft.exceptions.RequiredFieldException;
import br.tpmarc.arqsoft.models.Turma;

public class TurmaValidator implements ValidationStrategy<Turma> {

	@Override
	public void validate(Turma object) throws InvalidFieldException, RequiredFieldException {
		
		if (object.getCurso() == null) {
			throw new RequiredFieldException("Curso");
		}
		
		if (object.getSemestre() < 0 || object.getSemestre() > 2) {
			throw new InvalidFieldException("Semestre");
		}
		
		if (object.getAno() < 1946 && object.getAno() > DateTime.now().getYear()) {
			throw new InvalidFieldException("Ano");
		}
		
	}

}
