package br.tpmarc.arqsoft.dao;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.tpmarc.arqsoft.models.Curso;

public class CursoDao extends SQLiteHelper {
	
	private final int COLUMN_ID = 0;
	private final int COLUMN_CODIGO = 2;
	private final int COLUMN_NOME = 3;
	
	public CursoDao(Context ctx) {
		super(ctx);
	}
	
	public void add(Curso c) {
		SQLiteDatabase db = getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("codigo", c.getCodigo());
		values.put("nome", c.getNome());
		
		db.insert("cursos", null, values);
		db.close();
	}
	
	public void update(Curso c) {
		SQLiteDatabase db = getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("codigo", c.getCodigo());
		values.put("nome", c.getNome());

		String whereClause = "id = ?"; 
		String[] whereArgs = new String[] { Integer.toString(c.getId()) };
		
		db.update("cursos", values, whereClause, whereArgs);
		db.close();
	}
	
	public Curso get(int id) {
		
		SQLiteDatabase db = getWritableDatabase();
		
		String[] selectionArgs = new String[] { Integer.toString(id) };
		
		Cursor cursor = db.rawQuery("select * from cursos where id = ?", selectionArgs);
		
		Curso curso = null;
		
		if (cursor.moveToFirst()) {
			curso = new Curso();
			curso.setId(cursor.getShort(COLUMN_ID));
			curso.setCodigo(cursor.getString(COLUMN_CODIGO));
			curso.setNome(cursor.getString(COLUMN_NOME));
		}
		db.close();
		return curso;
	}
	
	public List<Curso> getAll() {
		List<Curso> cursos = new LinkedList<Curso>();
		
		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from cursos order by created_at desc", null);
		
		Curso curso = null;
		if (cursor.moveToFirst()) {
			do {
				curso = new Curso();
				curso.setId(cursor.getShort(COLUMN_ID));
				curso.setCodigo(cursor.getString(COLUMN_CODIGO));
				curso.setNome(cursor.getString(COLUMN_NOME));
				cursos.add(curso);
			} while(cursor.moveToNext());
		}
		
		db.close();
		
		return cursos;
	}
	
	public void delete(Curso c) {
		SQLiteDatabase db = getWritableDatabase();

		String whereClause = "id = ?"; 
		String[] whereArgs = new String[] { Integer.toString(c.getId()) };
		
		db.delete("cursos", whereClause, whereArgs);
		db.close();
	}
	
}
