package br.tpmarc.arqsort.activities;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.tpmarc.arqsoft.models.Curso;

public class CursoAdapter extends ArrayAdapter<Curso> {

	Context context;
	int resource;
	ArrayList<Curso> cursos;
	
	public CursoAdapter(Context context, int resource, ArrayList<Curso> cursos) {
		super(context, resource, cursos);
		this.context = context;
		this.resource = resource;
		this.cursos = cursos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v = convertView;
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(context);
            v = vi.inflate(resource, null);
        }
        Curso c = cursos.get(position);
        if (c != null) {
                TextView tt = (TextView) v.findViewById(R.id.txtToString);
                if (tt != null) {
                      tt.setText(c.toString());
                }
        }
        return v;
	}
	
}
