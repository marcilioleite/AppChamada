package br.tpmarc.arqsoft.data;

import android.content.Context;
import br.tpmarc.arqsoft.models.Aluno;

import com.db4o.ObjectSet;

public class AlunoDAO extends Persistor<Aluno> implements DAO<Aluno> {

	public AlunoDAO(Context context) {
		super(Aluno.class, context);
	}

	@Override
	public void salvar(Aluno obj) {
		store(obj);
		commit();
	}

	@Override
	public ObjectSet<Aluno> buscar(Aluno exemplo) {
		ObjectSet<Aluno> alunos = queryByExample(exemplo);
		return alunos;
	}

	@Override
	public ObjectSet<Aluno> todos() {
		ObjectSet<Aluno> alunos = query();
		return alunos;
	}

	@Override
	public void apagar(Aluno obj) {
		delete(obj);
		commit();
	}

}
