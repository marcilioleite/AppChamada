package br.tpmarc.arqsoft.exceptions;

public class RequiredFieldException extends Exception {
	private static final long serialVersionUID = 7609741019091325742L;

	public RequiredFieldException(String fieldName) {
		super(fieldName);
	}
}
