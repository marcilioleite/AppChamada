package br.tpmarc.arqsoft.facade;

import java.util.ArrayList;

import android.content.Context;
import br.tpmarc.arqsoft.dao.CursoDao;
import br.tpmarc.arqsoft.data.AlunoDAO;
import br.tpmarc.arqsoft.data.ChamadaDAO;
import br.tpmarc.arqsoft.data.TurmaDAO;
import br.tpmarc.arqsoft.models.Aluno;
import br.tpmarc.arqsoft.models.Chamada;
import br.tpmarc.arqsoft.models.Curso;
import br.tpmarc.arqsoft.models.Turma;

import com.db4o.ObjectSet;

public class Facade {

	private static Facade instancia;
	
	private Context context;
	
	private Facade() {
	}
	
	public void salvarCurso(Curso curso) {
		CursoDao dao = new CursoDao(context);
		if (curso.getId() == 0) {
			dao.add(curso);
		}
		else {
			dao.update(curso);
		}
	}
	
	public void apagarCurso(Curso curso) {
		CursoDao dao = new CursoDao(context);
		dao.delete(curso);
	}
	
	public Curso carregarCurso(int id) {
		CursoDao dao = new CursoDao(context);
		return dao.get(id);
	}
	
	public ArrayList<Curso> listarCursos() {
		CursoDao dao = new CursoDao(context);
		return new ArrayList<Curso>(dao.getAll());
	}
	
	public void salvarChamada(Chamada chamada) {
		ChamadaDAO chamadas = new ChamadaDAO(context);
		chamadas.salvar(chamada);
	}
	
	public void apagarChamada(Chamada chamada) {
		ChamadaDAO chamadas = new ChamadaDAO(context);
		chamadas.apagar(chamada);
	}
	

	public ObjectSet<Chamada> buscarChamadas(Chamada exemplo) {
		ChamadaDAO chamadas = new ChamadaDAO(context);
		return chamadas.buscar(exemplo);
	}
	
	public ObjectSet<Chamada> listarChamadas() {
		ChamadaDAO chamadas = new ChamadaDAO(context);
		return chamadas.todos();
	}
	
	public void salvarTurma(Turma turma) {
		TurmaDAO turmas = new TurmaDAO(context);
		turmas.salvar(turma);
	}
	
	public void apagarTurma(Turma turma) {
		TurmaDAO turmas = new TurmaDAO(context);
		turmas.apagar(turma);
	}
	
	public ObjectSet<Turma> buscarTurmas(Turma exemplo) {
		TurmaDAO turmas = new TurmaDAO(context);
		return turmas.buscar(exemplo);
	}

	public ObjectSet<Turma> listarTurmas() {
		TurmaDAO turmas = new TurmaDAO(context);
		return turmas.todos();
	}
	
	public void salvarAluno(Aluno aluno) {
		AlunoDAO alunos = new AlunoDAO(context);
		alunos.salvar(aluno);
	}
	
	public void apagarAluno(Aluno aluno) {
		AlunoDAO alunos = new AlunoDAO(context);
		alunos.apagar(aluno);
	}
	
	public ObjectSet<Aluno> buscarAluno(Aluno exemplo) {
		AlunoDAO alunos = new AlunoDAO(context);
		return alunos.buscar(exemplo);
	}

	public ObjectSet<Aluno> listarAlunos() {
		AlunoDAO alunos = new AlunoDAO(context);
		return alunos.todos();
	}
	
	public static Facade get(Context context) {
		if (instancia == null) {
			instancia = new Facade();
			instancia.context = context;
		}
		return instancia;
	}

}
