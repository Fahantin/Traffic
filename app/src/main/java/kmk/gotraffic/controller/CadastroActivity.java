package kmk.gotraffic.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kmk.gotraffic.dao.UsuarioDao;
import kmk.gotraffic.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private Button btnVoltar;
    private EditText edtEmail;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastrar = (Button) findViewById(R.id.cad_btnCadastrar);
        btnVoltar = (Button) findViewById(R.id.cad_btnVoltar);
        edtEmail = (EditText) findViewById(R.id.cad_edtEmail);
        edtSenha = (EditText) findViewById(R.id.cad_edtSenha);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltar();
            }
        });
    }

    protected void cadastrar() {
        String email = edtEmail.getText().toString().trim();
        String senha = edtSenha.getText().toString().trim();
        UsuarioDao dao = new UsuarioDao(getApplicationContext());

        if (email.equals("") || senha.equals("")) {
            Toast.makeText(getApplicationContext(), "Email e Senha Obrigatórios", Toast.LENGTH_SHORT).show();

        } else if (dao.verificaEmail(email)) {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(senha);
            dao.insertUsuario(usuario);
            Toast.makeText(getApplicationContext(), "Cadastro Efetuado com Sucesso", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Email Indisponível", Toast.LENGTH_SHORT).show();
        }
    }

    protected void voltar() {
        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
