package br.tpmarc.arqsoft.data;

import android.content.Context;

import com.db4o.ObjectSet;

public class Persistor<T> extends Db4oHelper implements IPersistor<T> {

	private Class<T> clazz;
	
	public Persistor(Class<T> clazz, Context context) {
		super(context);
		this.clazz = clazz;
	}
	
	public void store(T obj) {
		getDatabase().store(obj);
		commit();
	}
	
	public void delete(T obj) {
		getDatabase().delete(obj);
		commit();
	}
	
	public ObjectSet<T> query() {
		
		return getDatabase().query(clazz);
	}
	
	public ObjectSet<T> queryByExample(T exemplo) {
		
		return getDatabase().queryByExample(exemplo);
	}
	
}
