package br.tpmarc.arqsoft.data;

import com.db4o.ObjectSet;

public interface IPersistor<T> {

	void store(T obj);
	
	void delete (T obj);
	
	ObjectSet<T> query();
	
	ObjectSet<T> queryByExample(T exemplo);
	
}
