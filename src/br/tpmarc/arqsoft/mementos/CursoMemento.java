package br.tpmarc.arqsoft.mementos;

import br.tpmarc.arqsoft.models.Curso;

public class CursoMemento implements Memento {

	private Curso cursoTarget;

	private String codigo;
	
	private String nome;
	
	public CursoMemento(Curso c) {
		setCursoTarget(c);
		codigo = c.getCodigo();
		nome = c.getNome();
	}
	
	@Override
	public void desfazRefaz() {
		String codigoNovo = new String(codigo);
		String nomeNovo = new String(nome);
		
		codigo = cursoTarget.getCodigo();
		nome = cursoTarget.getNome();
		
		cursoTarget.setCodigo(codigoNovo);
		cursoTarget.setNome(nomeNovo);
	}
	
	public Curso getCursoTarget() {
		return cursoTarget;
	}

	public void setCursoTarget(Curso cursoTarget) {
		this.cursoTarget = cursoTarget;
	}
	
}
