package br.tpmarc.arqsort.activities;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import br.tpmarc.arqsoft.facade.Facade;
import br.tpmarc.arqsoft.models.Curso;

public class CursosListFragment extends Fragment implements OnItemClickListener, OnItemLongClickListener {

	private ListView listView;
	
	CursoAdapter adapter;
	
	private ArrayList<Curso> cursos;
	
	private int idSelecionado; 
	
	private int posicaoSelecionada;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
    	View layoutView = inflater.inflate(R.layout.fragment_cursos_list, container, false);
        
        listView = (ListView)layoutView.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        registerForContextMenu(listView);
        
        Context ctx = getActivity().getApplicationContext();
        cursos = Facade.get(ctx).listarCursos();
        
        adapter = new CursoAdapter(getActivity().getApplicationContext(), R.layout.row_curso, cursos);
        
        listView.setAdapter(adapter);
        
        return layoutView;
    }
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
		inflater.inflate(R.menu.menu_cursos, menu);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		
		super.onCreateContextMenu(menu, v, menuInfo);
		if (v.getId() == R.id.listView) {
			MenuInflater inflater = getActivity().getMenuInflater();
			inflater.inflate(R.menu.context, menu);
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.novo:
			
			Intent i = new Intent(getActivity().getApplicationContext(), CursoFormActivity.class);
			startActivity(i);
			
			return true;
		case R.id.config:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		
		case R.id.edit:
			
			Intent i = new Intent(getActivity().getApplicationContext(), CursoFormActivity.class);
			Bundle b = new Bundle();
			b.putInt("id", idSelecionado);
			i.putExtras(b);
			startActivity(i);
			
			return true;
			
		case R.id.delete:
			
			showDeleteConfirmDialog();
			
			return true;
		}
		
		return super.onContextItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		idSelecionado = cursos.get(position).getId();
		posicaoSelecionada = position;
		Log.v("LINHA SELECIONADA ", Integer.toString(posicaoSelecionada));
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		
		idSelecionado = cursos.get(position).getId();
		posicaoSelecionada = position;
		Log.v("LINHA SELECIONADA ", Integer.toString(posicaoSelecionada));
		return false;
	}
	
	private void showDeleteConfirmDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.msg_certeza).setTitle(R.string.title_apagar);
		builder.setPositiveButton(R.string.btn_positivo, new DialogInterface.OnClickListener()
	    {
	        @Override
	        public void onClick(DialogInterface dialog, int which) {
	        	
	        	Curso curso = cursos.get(posicaoSelecionada);

	        	Facade.get(getActivity().getApplicationContext()).apagarCurso(curso);
	        	adapter.remove(curso);
	        	
	        	adapter.notifyDataSetChanged();
	        	adapter.notifyDataSetInvalidated();
	        }
	    });
		builder.setNegativeButton(R.string.btn_negativo, null);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

}
