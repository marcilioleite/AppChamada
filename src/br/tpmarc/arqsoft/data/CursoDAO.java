package br.tpmarc.arqsoft.data;

import android.content.Context;
import br.tpmarc.arqsoft.models.Curso;

import com.db4o.ObjectSet;

public class CursoDAO extends Persistor<Curso> implements DAO<Curso> {

	public CursoDAO(Context context) {
		super(Curso.class, context);
	}

	@Override
	public void salvar(Curso obj) {
		store(obj);
	}

	@Override
	public ObjectSet<Curso> buscar(Curso exemplo) {
		return queryByExample(exemplo);
	}

	@Override
	public ObjectSet<Curso> todos() {
		return query();
	}

	@Override
	public void apagar(Curso obj) {
		delete(obj);
	}

}
