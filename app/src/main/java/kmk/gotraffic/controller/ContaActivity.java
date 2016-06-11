package kmk.gotraffic.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import kmk.gotraffic.model.Usuario;


public class ContaActivity extends AppCompatActivity {

    TextView txtEmail;
    TextView txtLevel;
    TextView txtExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        txtEmail = (TextView) findViewById(R.id.conta_Email);
        txtLevel = (TextView) findViewById(R.id.conta_Level);
        txtExp = (TextView) findViewById(R.id.conta_Exp);


        txtEmail.setText(LoginActivity.user.getEmail());
        txtLevel.setText(String.valueOf(LoginActivity.user.getLevel()));
        txtExp.setText(String.valueOf(LoginActivity.user.getExp()));
    }
}