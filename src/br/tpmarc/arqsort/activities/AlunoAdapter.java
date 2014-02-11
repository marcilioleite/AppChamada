package br.tpmarc.arqsort.activities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.tpmarc.arqsoft.models.Aluno;

public class AlunoAdapter extends ArrayAdapter<Aluno> {

	Context context;
	int layoutId;
	Aluno[] data; 
	
	public AlunoAdapter(Context context, int resource, Aluno[] data) {
		super(context, resource);
		this.context = context;
		this.layoutId = resource;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View row = convertView;
		AlunoHolder holder = null;
		
		if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutId, parent, false);
            
            holder = new AlunoHolder();
            holder.txtNome = (TextView)row.findViewById(R.id.txtNome);
            
            row.setTag(holder);
            
		} else {
			
            holder = (AlunoHolder)row.getTag();
        }
        
        Aluno aluno = data[position];
        holder.txtNome.setText(aluno.getNome());
        
        return row;
	}
	
	static class AlunoHolder {
		TextView txtNome;
	}
}
