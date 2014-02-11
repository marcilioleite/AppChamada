package br.tpmarc.arqsoft.validators;

import br.tpmarc.arqsoft.exceptions.InvalidFieldException;
import br.tpmarc.arqsoft.exceptions.RequiredFieldException;
import br.tpmarc.arqsoft.models.Aula;

public class AulaValidator implements ValidationStrategy<Aula> {

	@Override
	public void validate(Aula object) throws InvalidFieldException, RequiredFieldException {
		
		if (object.getInicio() == null) {
			throw new RequiredFieldException("Horário do Início");
		} 
		
		if (object.getFim() == null) {
			throw new RequiredFieldException("Horário do Fim");
		} else if (object.getFim().isBefore(object.getInicio())) {
			throw new InvalidFieldException("Horário do Início");
		}
		
		if (object.getTurma() == null) {
			throw new RequiredFieldException("Turma");
		}
	}

	
	
}
