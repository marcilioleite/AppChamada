package br.tpmarc.arqsort.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import br.tpmarc.arqsoft.data.CursoDAO;
import br.tpmarc.arqsoft.exceptions.InvalidFieldException;
import br.tpmarc.arqsoft.exceptions.RequiredFieldException;
import br.tpmarc.arqsoft.facade.Facade;
import br.tpmarc.arqsoft.models.Curso;
import br.tpmarc.arqsoft.validators.CursoValidator;

public class CursoFormActivity extends Activity {

	private CursoDAO dao;
	
	private Curso curso;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_curso_form);
		
		
		Bundle b = getIntent().getExtras();
		
		if (b != null) {	
			if (b.containsKey("id")) {
				int id = b.getInt("id");
				curso = Facade.get(getApplicationContext()).carregarCurso(id);
				
				bindFormWithBean();
			}	
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.form, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		
		case R.id.save:
			
			CursoValidator validator = new CursoValidator();
			
			if (curso != null) {
				bindBeanFromForm();
			}
			else {
				makeBeanFromForm();
			}

			try {
				validator.validate(curso);
				Facade.get(getApplicationContext()).salvarCurso(curso);
				showToastMessage();
				goToMainActivity();
			} catch (InvalidFieldException e) {
				showInvalidFieldDialog(e);
			} catch (RequiredFieldException e) {
				showRequiredFieldDialog(e);
			}

			return true;
			
		case R.id.cancel:
			
			goToMainActivity();
			
			return true;
			
		default:
			return super.onOptionsItemSelected(item);			
		}
		
	}

	private void showRequiredFieldDialog(RequiredFieldException e) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(e.getMessage()).setTitle(R.string.campo_necessario);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void showInvalidFieldDialog(InvalidFieldException e) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(e.getMessage()).setTitle(R.string.campo_invalido);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void bindBeanFromForm() {
		EditText editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
		EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
		
		curso.setCodigo(editTextCodigo.getText().toString());
		curso.setNome(editTextNome.getText().toString());
	}
	
	private void makeBeanFromForm() {
		EditText editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
		EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
		
		curso = new Curso();
		curso.setCodigo(editTextCodigo.getText().toString());
		curso.setNome(editTextNome.getText().toString());
	}

	private void goToMainActivity() {
		Intent intent;
		intent = new Intent(CursoFormActivity.this, MainActivity.class);
		startActivity(intent);
	}

	private void showToastMessage() {
		Context context = getApplicationContext();
		CharSequence text = "O registro do curso foi salvo!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	private void bindFormWithBean() {
		EditText editTextCodigo = (EditText)findViewById(R.id.editTextCodigo);
		EditText editTextNome = (EditText)findViewById(R.id.editTextNome);
		
		editTextCodigo.setText(curso.getCodigo());
		editTextNome.setText(curso.getNome());
	}
	
}
