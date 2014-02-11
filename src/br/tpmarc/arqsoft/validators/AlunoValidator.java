package br.tpmarc.arqsoft.validators;

import br.tpmarc.arqsoft.exceptions.InvalidFieldException;
import br.tpmarc.arqsoft.exceptions.RequiredFieldException;
import br.tpmarc.arqsoft.models.Aluno;

public class AlunoValidator implements ValidationStrategy<Aluno> {

	@Override
	public void validate(Aluno object) throws InvalidFieldException, RequiredFieldException {

		if (object.getNome().isEmpty()) {
			throw new RequiredFieldException("Nome");
		} else if (object.getNome().length() < 5) {
			throw new InvalidFieldException("Nome");
		}
		
		if (object.getEmail().isEmpty()) {
			throw new RequiredFieldException("E-mail");
		} else if (object.getEmail().matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
			throw new InvalidFieldException("E-mail");
		}
		
	}


}
