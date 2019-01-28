package facci.sanchezarteagajose.a2kg.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import facci.sanchezarteagajose.a2kg.R;


public class validacion extends AppCompatActivity {
    EditText EditTextcorreo;
    EditText EditTextpasword;
    EditText EditTextnombre;
    EditText EditTextapellido;
    EditText EditTextcedula;
    EditText EditTextVerificacion;


    @Override

    protected void onCreate(Bundle savedInstateState) {
        super.onCreate(savedInstateState);
        setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_registro);
        EditTextpasword= (EditText) findViewById(R.id.EditT_password);
        EditTextnombre=(EditText) findViewById(R.id.EditT_nombre);
        EditTextcedula=(EditText) findViewById(R.id.EditT_cedula);
        EditTextapellido=(EditText) findViewById(R.id.EditT_apellido);



        Button Btn_registrase=(Button) findViewById(R.id.Btn_registrar);
        Btn_registrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacion();
            }
        });
        Button Btn_inicio = (Button) findViewById(R.id.btnLogin);
        Btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacion();
            }
        });

    }
    public void validacion(){
        EditTextcorreo.setError(null);
        EditTextpasword.setError(null);
        EditTextnombre.setError(null);
        EditTextapellido.setError(null);
        EditTextcedula.setError(null);
        EditTextVerificacion.setError(null);



        String correo=EditTextcorreo.getText().toString().trim();
        String pasword=EditTextpasword.getText().toString().trim();
        String cedula=EditTextpasword.getText().toString().trim();
        String nombres=EditTextnombre.getText().toString().trim();
        String apellidos=EditTextapellido.getText().toString().trim();
        String verificacion= EditTextVerificacion.getText().toString().trim();

        if(TextUtils.isEmpty(correo)){
            EditTextcorreo.setError(getString(R.string.erro_campo_obligario));
            EditTextcorreo.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(pasword)){
            EditTextpasword.setError(getString(R.string.erro_campo_obligario));
            EditTextpasword.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(nombres)){
            EditTextnombre.setError(getString(R.string.erro_campo_obligario));
            EditTextnombre.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(apellidos)){
            EditTextapellido.setError(getString(R.string.erro_campo_obligario));
            EditTextapellido.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(verificacion)){
            EditTextVerificacion.setError(getString(R.string.erro_campo_obligario));
           EditTextVerificacion.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(cedula)){
            EditTextcedula.setError(getString(R.string.erro_campo_obligario));
            EditTextcedula.requestFocus();
            return;
        }

        Toast.makeText(getApplicationContext(),"Se ha  Registrado correctamente", Toast.LENGTH_SHORT).show();


        if(TextUtils.isEmpty(correo)){
            EditTextcorreo.setError(getString(R.string.cantidad_caracteres_8));
            EditTextcorreo.requestFocus();
            return;
        }

    }
}
