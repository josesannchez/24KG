package facci.sanchezarteagajose.a2kg.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import facci.sanchezarteagajose.a2kg.Consejo;
import facci.sanchezarteagajose.a2kg.Contacto;
import facci.sanchezarteagajose.a2kg.R;
import facci.sanchezarteagajose.a2kg.Servicios;

public class Login extends AppCompatActivity {

    EditText et_correo, et_password;    //CREACIÓN DE VARIABLES
    TextView tv_registrar;
    private Button btn_log;
    private ProgressBar loading;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {   //AQUI CREO UN PROTECT VOID ONCREATE QUE HACE GUARDAR Y ENVIAR LOS DATOS DEL ACTIVITY
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         loading =findViewById(R.id.progress);
         sessionManager = new SessionManager(this);
        tv_registrar = (TextView) findViewById(R.id.tvRegister);   //AQUI DIGO QUE LAS VARIABLES SEAN IGUAL AL TEXTO QUE ESTOY TOMANDO EN EL ACTIVIVY
        et_correo = (EditText) findViewById(R.id.etcorreo);
        et_password = (EditText) findViewById(R.id.etUserPassword);
        btn_log = (Button) findViewById(R.id.btnLogin);
/*
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
            return;
        }
*/
        tv_registrar.setOnClickListener(new View.OnClickListener() {//AQUI DIGO QUE AL HACER CLIC EN EL TEXT ABRA EL LA CLASE REGISTRO
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(Login.this, Registro.class);
                Login.this.startActivity(intentReg);
            }
        });   //


        btn_log.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {      //AQUI DIGO QUE EN EL BOTON LOGIN HAGA LO SIGUIENTE....

                                           if (et_correo.getText().toString().isEmpty()){  //AQUI DIGO SI EL CAMPO RUT ESTÁ VACÍO

                                               Toast.makeText(Login.this, "Debe ingresar el correo", Toast.LENGTH_SHORT).show(); //MANDE UN MENSAJE QUE DEBE INGRESAR RUT

                                           }else if (et_password.getText().toString().isEmpty()) {
                                               //AQUI DIGO SI EL CAMPO PASSWORD ESTÁ VACÍO, TAMBIÉN MANDE UN MENSAJE DE QUE ESTÁ VACÍO

                                               Toast.makeText(Login.this, "Debe ingresar contraseña", Toast.LENGTH_SHORT).show();

                                           }
                                           loading.setVisibility(View.VISIBLE);
                                           final String correo = et_correo.getText().toString(); //YA SI SE CUMPLEN LOS CAMPOS, DIGO QUE TOME LO QUE SE ESTÁ INSERTANDO
                                           final String password = et_password.getText().toString();
                                           Response.Listener<String> responseListener = new Response.Listener<String>() { //LLAMO AL ESCUCHADOR
                                               @Override
                                               public void onResponse(String response) {

                                                   try {
                                                       JSONObject jsonResponse = new JSONObject(response);
                                                       boolean success = jsonResponse.getBoolean("success");
                                                       if (success) {
                                                           //Y HAGO AQUÍ UN TRY CATCH Y LLAMO AL JSONOBJECT y digo si está bien

                                                           String nombres = jsonResponse.getString("nombres");
                                                           String correo = jsonResponse.getString("correo");
                                                           //TOMA EL DATO NOMBRE DEL PHP NOMBRE
                                                           sessionManager.createSession(nombres,correo);
                                                           Intent actividad = new Intent(Login.this,Servicios.class);
                                                           //Y AQUI HAGO UN INTENT Y DIGO QUE HABRA LA CLASE USUARIO Y TOME EL NOMBRE
                                                           actividad.putExtra("nombres", nombres);
                                                           actividad.putExtra("correo", correo);
                                                           Login.this.startActivity(actividad);
                                                           finish();
                                                           loading.setVisibility(View.GONE);

                                                       } else {
                                                           AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                                           builder.setMessage("correo y/o Contraseña Incorrecto")
                                                                   .setNegativeButton("Volver", null)
                                                                   .create().show();
                                                           loading.setVisibility(View.GONE);
                                                           //DE CASO CONTRARIO, SI LA CLAVE ES ERRORNEA MANDE UN MENSAJE DE ALERTA QUE ESTÁ EQUIVOCADA

                                                       }

                                                   } catch (JSONException e) {
                                                       loading.setVisibility(View.GONE);
                                                       btn_log.setVisibility(View.VISIBLE);
                                                       e.printStackTrace();
                                                   }


                                               }

                                           };

                                           LoginRequest loginRequest = new LoginRequest(correo, password,responseListener);
                                           RequestQueue queue = Volley.newRequestQueue(Login.this);
                                           queue.add(loginRequest);  }   //AQUI DIGO QUE TOME LOS DATOS RUT Y CONTRASEÑA, CON EL ESCUCHADOR Y LO EJECUTE





                                   }


        );

    }
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto:
                intent =new Intent(Login.this,Contacto.class);
                startActivity(intent);
                break;
            case R.id.consejo:
                intent =new Intent(Login.this,Consejo.class);
                startActivity(intent);
                break;
        }
        return  true;
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus,menu);
        return true;



    }
}