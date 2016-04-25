package kmk.gotraffic.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaLogin extends AppCompatActivity {

    public EditText edtEmail;
    public EditText edtSenha;

    private Button btnEntrar;
    private Button btnCadastrar;

    private kmk.gotraffic.controller.validation.TelaLogin telaLogin;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        getSupportActionBar().hide();
        telaLogin = new kmk.gotraffic.controller.validation.TelaLogin();

        preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        String email = preferences.getString("email", null);
        String senha = preferences.getString("senha", null);

        if (email != null && senha != null) {
            Intent intent = new Intent(TelaLogin.this, Principal.class);
            startActivity(intent);
            finish();
        }

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btnEntrar = (Button) findViewById(R.id.login_btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String senha = edtSenha.getText().toString();

                boolean isValido = telaLogin.validarCamposLogin(TelaLogin.this, email, senha, edtEmail, edtSenha);

                if (isValido) {
                    Intent intent = new Intent(TelaLogin.this, Principal.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}