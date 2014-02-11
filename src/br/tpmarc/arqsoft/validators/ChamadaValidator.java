package br.tpmarc.arqsoft.validators;

import br.tpmarc.arqsoft.exceptions.InvalidFieldException;
import br.tpmarc.arqsoft.exceptions.RequiredFieldException;
import br.tpmarc.arqsoft.models.Chamada;

public class ChamadaValidator implements ValidationStrategy<Chamada> {

	@Override
	public void validate(Chamada object) throws InvalidFieldException, RequiredFieldException {
		
		if (object.getAula() == null) {
			throw new RequiredFieldException("Aula");
		}
		
	}

}
