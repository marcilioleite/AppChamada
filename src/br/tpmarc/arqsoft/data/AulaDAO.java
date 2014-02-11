package br.tpmarc.arqsoft.data;

import android.content.Context;
import br.tpmarc.arqsoft.models.Aula;

import com.db4o.ObjectSet;

public class AulaDAO extends Persistor<Aula> implements DAO<Aula> {

	public AulaDAO(Context context) {
		super(Aula.class, context);
	}

	@Override
	public void salvar(Aula obj) {
		store(obj);
		commit();
	}

	@Override
	public ObjectSet<Aula> buscar(Aula exemplo) {
		ObjectSet<Aula> aulas = queryByExample(exemplo);
		return aulas;
	}

	@Override
	public ObjectSet<Aula> todos() {
		ObjectSet<Aula> aulas = query();
		return aulas;
	}

	@Override
	public void apagar(Aula obj) {
		delete(obj);
		commit();
	}

}
