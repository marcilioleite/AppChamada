package br.tpmarc.arqsoft.data;

import android.content.Context;
import br.tpmarc.arqsoft.models.Chamada;

import com.db4o.ObjectSet;

public class ChamadaDAO extends Persistor<Chamada> implements DAO<Chamada> {

	public ChamadaDAO(Context context) {
		super(Chamada.class, context);
	}

	@Override
	public void salvar(Chamada obj) {
		store(obj);
		commit();
	}

	@Override
	public ObjectSet<Chamada> buscar(Chamada exemplo) {
		ObjectSet<Chamada> chamadas = queryByExample(exemplo);
		return chamadas;
	}

	@Override
	public ObjectSet<Chamada> todos() {
		ObjectSet<Chamada> chamadas = query();
		return chamadas;
	}

	@Override
	public void apagar(Chamada obj) {
		delete(obj);
		commit();
	}

}
