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
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import facci.sanchezarteagajose.a2kg.Consejo;
import facci.sanchezarteagajose.a2kg.Contacto;
import facci.sanchezarteagajose.a2kg.R;


public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText etnombre, etapellido, etcorreo, etpassword, etRespassword,etcedula;; //CREACION DE VARIABLES

    Button btn_registrar;
    private ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        etnombre = findViewById(R.id.EditT_nombre);  //AQUI ESTOY DEFINIENDO LOS VALORES DE LAS VARIABLES DEL ACTIVITY REGISTRO
        etapellido = findViewById(R.id.EditT_apellido);
        loading =findViewById(R.id.progress);
        etcorreo = findViewById(R.id.EditT_correo);
        etpassword = findViewById(R.id.EditT_password);
        etcedula = findViewById(R.id.EditT_cedula);
        etRespassword=findViewById(R.id.EditT_secreta);
        btn_registrar = findViewById(R.id.Btn_registrar);     //AQUI HAGO CLICK EN EL BOTON Y HACE LO SIGUIENTE
        btn_registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        final String nombres = etnombre.getText().toString();  //AL HACER CLIC TOMA LOS VALORES FINALES Y LOS PASA A STRING
        final String apellidos = etapellido.getText().toString();
        final String password = etpassword.getText().toString();
        final String cedula = etcedula.getText().toString();
        final String correo = etcorreo.getText().toString();
        final String verificacion = etRespassword.getText().toString();

        loading.setVisibility(View.VISIBLE);

        final Response.Listener<String> respoLister = new Response.Listener<String>() {  //LLAMA AL ESCUCHADOR
            @Override
            public void onResponse(String response) {


                if (etnombre.getText().toString().isEmpty()) {  //SE APLICA UNA CONDICIÓN SI LOS CAMPOS ESTÁN VACÍOS

                    Toast.makeText(Registro.this, "Debe ingresar nombre", Toast.LENGTH_SHORT).show();
                    //SE MANDA MENSAJE

                } else if (etapellido.getText().toString().isEmpty()) {

                    Toast.makeText(Registro.this, "Debe ingresar apellido", Toast.LENGTH_SHORT).show();

                } else if (etcorreo.getText().toString().isEmpty()) {


                    Toast.makeText(Registro.this, "Debe ingresar el correo", Toast.LENGTH_SHORT).show();

                } else if (etpassword.getText().toString().isEmpty()) {

                    Toast.makeText(Registro.this, "Debe ingresar contraseña", Toast.LENGTH_SHORT).show();

                } else if (etcedula.getText().toString().isEmpty()) {

                    Toast.makeText(Registro.this, "ingrese su cedula", Toast.LENGTH_SHORT).show();
                }
                else if (etRespassword.getText().toString().isEmpty()) {

                    Toast.makeText(Registro.this, "Debe verificar su contraseña", Toast.LENGTH_SHORT).show();
                }
                loading.setVisibility(View.VISIBLE);
                try {
                    JSONObject jsonReponse = new JSONObject(response);
                    boolean success = jsonReponse.getBoolean("success");
                    //YA SI NO HAY NINGUN PROBLEMA HACE LO SIGUIENTE....
                    if (success) {
                        //AQUÍ DIGO SI SE REGISTRÓ CORRECTAMENTE MANDO UN MENSAJE
                        Toast.makeText(Registro.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Registro.this, Login.class);
                        Registro.this.startActivity(intent);

                    } else {
                        //DE CASO CONTRARIO DIGO QUE EL ALUMNO YA ESTÁ REGISTRADO

                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("Usuario ya está registrado ").setNegativeButton("Volver", null).create().show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    loading.setVisibility(View.GONE);
                    btn_registrar.setVisibility(View.VISIBLE);
                }

            }
        };

        RegisterRequest registerRequest = new RegisterRequest(nombres, apellidos,cedula,correo,password,verificacion, respoLister);
        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);  //AQUI TOMO LAS VARIABLES Y LAS EJECUTO

    }

    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto:
                intent =new Intent(Registro.this,Contacto.class);
                startActivity(intent);
                break;
            case R.id.consejo:
                intent =new Intent(Registro.this,Consejo.class);
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