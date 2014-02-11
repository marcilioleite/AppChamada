package br.tpmarc.arqsort.activities;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		actionBar.addTab(actionBar.newTab().setText(R.string.aulas)
		        .setTabListener(this));
		    actionBar.addTab(actionBar.newTab().setText(R.string.turmas)
		        .setTabListener(this));
		    actionBar.addTab(actionBar.newTab().setText(R.string.alunos)
		        .setTabListener(this));
		    actionBar.addTab(actionBar.newTab().setText(R.string.cursos)
			        .setTabListener(this));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		/*
		switch (item.getItemId()) {
		case R.id.action_new:
			return true;
		case R.id.action_config:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		*/
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		
		Fragment fragment = null;
		
		switch(tab.getPosition()) {
		case 0:
			fragment = new AulasListFragment();
			break;
		case 1:
			fragment = new TurmasListFragment();
			break;
		case 2:
			fragment = new AlunosListFragment();
			break;
		default:
			fragment = new CursosListFragment();
			break;
		}
		
		getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
}
