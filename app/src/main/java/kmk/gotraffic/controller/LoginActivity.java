package kmk.gotraffic.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kmk.gotraffic.controller.validation.LoginValidation;
import kmk.gotraffic.dao.UsuarioDao;

public class LoginActivity extends AppCompatActivity {

    public EditText edtEmail;
    public EditText edtSenha;
    private Button btnEntrar;
    private Button btnCadastrar;
    private Toast toast;
    private LoginValidation loginValidation;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        edtEmail = (EditText) findViewById(R.id.login_edtEmail);
        edtSenha = (EditText) findViewById(R.id.login_edtSenha);
        btnEntrar = (Button) findViewById(R.id.login_btnEntrar);
        btnCadastrar = (Buatton) findViewById(R.id.login_btnCadastrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
    }

    protected void entrar() {
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        UsuarioDao dao = new UsuarioDao(getApplicationContext());

        toast = Toast.makeText(getApplicationContext(), email + " - " + senha, Toast.LENGTH_SHORT);
        toast.show();

        if (dao.validaLogin(email, senha)) {
            email = preferences.getString("email", null);
            senha = preferences.getString("senha", null);

            Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
            startActivity(intent);
            finish();
        } else {
            toast = Toast.makeText(getApplicationContext(), "Usuário Não Encontrado", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    protected void cadastrar() {
        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(intent);
        finish();
    }
}
