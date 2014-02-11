package br.tpmarc.arqsoft.validators;

import br.tpmarc.arqsoft.exceptions.InvalidFieldException;
import br.tpmarc.arqsoft.exceptions.RequiredFieldException;

public interface ValidationStrategy<T> {

	void validate(T object) throws InvalidFieldException, RequiredFieldException;
	
}
