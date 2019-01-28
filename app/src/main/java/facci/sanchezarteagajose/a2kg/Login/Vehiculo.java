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

public class Vehiculo extends AppCompatActivity implements View.OnClickListener {
    EditText edmarca,edmodelo,edcompra,edmatricula; //CREACION DE VARIABLES
    TextView tvNombre, tvapellidos, tvEmail, tvPassword;
    //Textview to show currently logged in us
    // er
    private TextView textView;
    Button Logout;
    Button btn_enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vehiculo);
        edmodelo= findViewById(R.id.txt_modelo);  //AQUI ESTOY DEFINIENDO LOS VALORES DE LAS VARIABLES DEL ACTIVITY REGISTRO
        edmatricula= findViewById(R.id.txt_matricula);
        edmarca = findViewById(R.id.txt_marca);
        edcompra= findViewById(R.id.txt_AñoCompra);
        btn_enviar = findViewById(R.id.Btn_vehiculo);     //AQUI HAGO CLICK EN EL BOTON Y HACE LO SIGUIENTE
        btn_enviar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        final String marca = edmarca.getText().toString();  //AL HACER CLIC TOMA LOS VALORES FINALES Y LOS PASA A STRING
        final String modelo= edmodelo.getText().toString();
        final String matricula= edmatricula.getText().toString();
        final  int age= Integer.parseInt(edcompra.getText().toString());




        final Response.Listener<String> respoLister = new Response.Listener<String>() {  //LLAMA AL ESCUCHADOR
            @Override
            public void onResponse(String response) {
                if (edmarca.getText().toString().isEmpty()) {  //SE APLICA UNA CONDICIÓN SI LOS CAMPOS ESTÁN VACÍOS

                    Toast.makeText(Vehiculo.this, "Debe ingresar la marca del vehiculo", Toast.LENGTH_SHORT).show();
                    //SE MANDA MENSAJE

                } else if (edmodelo.getText().toString().isEmpty()) {

                    Toast.makeText(Vehiculo.this, "Debe ingresar el modelo", Toast.LENGTH_SHORT).show();

                } else if (edmatricula.getText().toString().isEmpty()) {

                    Toast.makeText(Vehiculo.this, "Debe ingresar ela matricula", Toast.LENGTH_SHORT).show();

                } else if (edcompra.getText().toString().isEmpty()) {

                    Toast.makeText(Vehiculo.this, "Debe ingresar el año en que compro su vehiculo", Toast.LENGTH_SHORT).show();

                }
                try {
                    JSONObject jsonReponse = new JSONObject(response);
                    boolean success = jsonReponse.getBoolean("success");
                    //YA SI NO HAY NINGUN PROBLEMA HACE LO SIGUIENTE....
                    if (success) {

                        //AQUÍ DIGO SI SE REGISTRÓ CORRECTAMENTE MANDO UN MENSAJE
                        Toast.makeText(Vehiculo.this, "AutoRegistrado", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Vehiculo.this, HORARIO.class);

                        Vehiculo.this.startActivity(intent);



                    } else {
                        //DE CASO CONTRARIO DIGO QUE EL auto YA ESTÁ REGISTRADO

                        AlertDialog.Builder builder = new AlertDialog.Builder(Vehiculo.this);
                        builder.setMessage("Este vehiculo ya fue registrado intente con otro").setNegativeButton("Volver", null).create().show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

     VehiculoRequest register = new VehiculoRequest(marca,modelo,matricula,age,respoLister);
        RequestQueue queue = Volley.newRequestQueue(Vehiculo.this);
        queue.add(register);  //AQUI TOMO LAS VARIABLES Y LAS EJECUTO

    }
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto:
                intent =new Intent(Vehiculo.this,Contacto.class);
                startActivity(intent);
                break;
            case R.id.consejo:
                intent =new Intent(Vehiculo.this,Consejo.class);
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