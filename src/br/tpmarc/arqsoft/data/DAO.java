package br.tpmarc.arqsoft.data;

import com.db4o.ObjectSet;

public interface DAO<T> {
	
	public void salvar(T obj);
	
	public ObjectSet<T> buscar(T exemplo);
	
	public ObjectSet<T> todos();
	
	public void apagar(T obj);

}
