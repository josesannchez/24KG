package facci.sanchezarteagajose.a2kg;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import facci.sanchezarteagajose.a2kg.Login.Login;


public class MainActivity extends AppCompatActivity  {
    Button button4Siguiente;
    TextView datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button4Siguiente = (Button) findViewById(R.id.button4Siguiente);
        button4Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(MainActivity.this, Servicios.class);
                startActivity(intent);
            } });
        datos = (TextView) findViewById(R.id.button2Registrar);
        datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            } });

    }
    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto:
                intent =new Intent (MainActivity.this,Contacto.class);
                startActivity(intent);
                break;
            case R.id.consejo:
                intent =new Intent (MainActivity.this,Consejo.class);
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
