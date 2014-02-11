package br.tpmarc.arqsort.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import br.tpmarc.arqsoft.models.Aluno;
import br.tpmarc.arqsoft.validators.AlunoValidator;

public class AlunoFormActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aluno_form);
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
			
			EditText editTextCodigo = (EditText) findViewById(R.id.editTextCodigo);
			EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
			
			Aluno aluno = new Aluno();
			
			AlunoValidator validator = new AlunoValidator();
			
			showToastMessage();
			
			goToMainActivity();
			
			return true;
		case R.id.cancel:
			
			goToMainActivity();
			
			return true;
		default:
			return super.onOptionsItemSelected(item);			
		}
		
	}

	private void goToMainActivity() {
		Intent intent;
		intent = new Intent(AlunoFormActivity.this, MainActivity.class);
		startActivity(intent);
	}

	private void showToastMessage() {
		Context context = getApplicationContext();
		CharSequence text = "O registro do aluno foi salvo!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

}
