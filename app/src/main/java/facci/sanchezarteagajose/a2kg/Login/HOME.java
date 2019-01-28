package facci.sanchezarteagajose.a2kg.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import facci.sanchezarteagajose.a2kg.R;

public class HOME extends AppCompatActivity {
    TextView tvNombre, tvUsuario, tvEmail, tvPassword;
    SessionManager sessionManager;
    Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sessionManager = new SessionManager(this);
sessionManager.checkLogin();
HashMap<String,String>user =sessionManager.getUserDetail();
String nombres=user.get(sessionManager.NAME);
String correo=user.get(sessionManager.EMAIL);
            tvNombre = findViewById(R.id.TextV_nombre);
            tvUsuario = findViewById(R.id.TextV_usuario);
            tvEmail = findViewById(R.id.TextV_email);
            tvPassword = findViewById(R.id.TextV_password);
            tvUsuario.setText(nombres);
            tvEmail.setText(correo);
btn_logout=findViewById(R.id.btn_logout);
btn_logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        sessionManager.logout();
        finish();
    }
});

        }
}
