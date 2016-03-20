package kmk.gotraffic.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kmk.gotraffic.view.util.TipAlert;
import kmk.gotraffic.view.util.Util;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnHole = (Button) findViewById(R.id.principal_btnHole);
        btnHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.showAlert(Principal.this, "Testando", TipAlert.HOLE);
            }
        });

        Button btnCrash = (Button) findViewById(R.id.principal_btnCrash);
        btnCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.showAlert(Principal.this, "Testando", TipAlert.CRASH);
            }
        });

        Button btnTraffic = (Button) findViewById(R.id.principal_btnTraffic);
        btnTraffic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.showAlert(Principal.this, "Testando", TipAlert.TRAFFIC);
            }
        });

    }
}
