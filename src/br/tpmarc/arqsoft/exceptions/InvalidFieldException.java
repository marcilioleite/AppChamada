package br.tpmarc.arqsoft.exceptions;

public class InvalidFieldException extends Exception {
	private static final long serialVersionUID = 5568630088165836730L;
	
	public InvalidFieldException(String fieldName) {
		super(fieldName);
	}
}
