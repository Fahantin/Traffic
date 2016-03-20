package controller;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Thiago Fantin on 19/03/2016.
 */
public class TelaLogin {

    public boolean validarCamposLogin(Activity activity, String email, String senha, EditText edtEmail, EditText edtSenha) {
        boolean resultado = true;
        if (email == null || "".equals(email)) {
            edtEmail.setError("Campo obrigatório!");
            resultado = false;
        } else if (email.length() < 5) {
            edtEmail.setError("Mínimo 5 caracteres!");
            resultado = false;
        }
        if (senha == null || "".equals(senha)) {
            edtSenha.setError("Campo obrigatório!");
            resultado = false;
        } else if (senha.length() < 5) {
            edtSenha.setError("Mínimo 5 caracteres!");
            resultado = false;
        }
        if (resultado) {
            if ((!email.equals("admin")) || (!senha.equals("12345"))) {
                Toast.makeText(activity, "Email ou Senha Inválidos!", Toast.LENGTH_SHORT).show();
                resultado = false;
            } else {
                SharedPreferences.Editor editor = activity.getSharedPreferences("login", Context.MODE_PRIVATE).edit();
                editor.putString("email", email);
                editor.putString("senha", senha);
                editor.commit();
            }
        }
        return resultado;
    }
}