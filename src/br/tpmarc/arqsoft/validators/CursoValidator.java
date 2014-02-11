package br.tpmarc.arqsoft.validators;

import br.tpmarc.arqsoft.exceptions.InvalidFieldException;
import br.tpmarc.arqsoft.exceptions.RequiredFieldException;
import br.tpmarc.arqsoft.models.Curso;

public class CursoValidator implements ValidationStrategy<Curso> {

	@Override
	public void validate(Curso object) throws InvalidFieldException, RequiredFieldException {
		
		if (object.getCodigo() == null || object.getCodigo().isEmpty()) {
			throw new RequiredFieldException("Código");
		}
		
		if (object.getNome() == null || object.getNome().isEmpty()) {
			throw new RequiredFieldException("Nome");
		}
	}

}
