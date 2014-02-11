package br.tpmarc.arqsort.activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AlunosListFragment extends Fragment {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
		inflater.inflate(R.menu.menu_alunos, menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.novo:
			
			Intent i = new Intent(getActivity().getApplicationContext(), AlunoFormActivity.class);
			startActivity(i);
			
			return true;
			
		case R.id.config:
			
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
        View layoutView = inflater.inflate(R.layout.fragment_alunos_list, container, false);
        
        ListView listView = (ListView)layoutView.findViewById(R.id.listView);
        /*
        List<Aluno> alunos = Facade.getInstancia(getActivity().getApplicationContext()).listarAlunos();
        Aluno[] data = new Aluno[alunos.size()];
        alunos.toArray(data);
        
        AlunoAdapter adapter = new AlunoAdapter(getActivity().getApplicationContext(), 
        										R.layout.list_item_aluno, 
        										data);
        
        listView.setAdapter(adapter);
        */
        return layoutView;
    }

}
