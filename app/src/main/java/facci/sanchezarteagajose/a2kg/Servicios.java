package facci.sanchezarteagajose.a2kg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import facci.sanchezarteagajose.a2kg.Login.HORARIO;
import facci.sanchezarteagajose.a2kg.Login.Vehiculo;


public class Servicios extends AppCompatActivity {
    Button modelo;
    ListView lista2;
    String[][] datos2 = {
            {"Cambio de Aceite", "", "88822", "", " Se realiza si el cleinte lo desea"},
            {"Chasis", "", "82225", "", "reparamos el chasi a nivel de los profesionales"},
            {"Direccionales", "", "849998", "", " necesario para evitar posible fallos en su conduncion "},
            {"Llantas", "", "949494", "", "Paa por dos pilotos cuyas mentes están unid     ."},
            {"Suspension", "", "55844", "", "Se realizara unicamente si el cliente lo desea"},
            {"Motor", "", "4844148", "", "el cobro dependera de que tan mal es te el motor"}
    };
    int[] datosImg2 = {R.drawable.cambioaceite, R.drawable.chasis, R.drawable.dreccionales, R.drawable.llantas, R.drawable.sunpension, R.drawable.motor};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_servicios);

            lista2 = (ListView) findViewById(R.id.lvLista);

            lista2.setAdapter(new adaptador2(this, datos2, datosImg2));

            lista2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent detalles = new Intent(view.getContext(), Vehiculo.class);
                    detalles.putExtra("TIT", datos2[position][0]);
                    detalles.putExtra("DET", datos2[position][4]);
                    startActivity(detalles);
                }
            });
fileList();
    }

    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto:
                intent =new Intent(Servicios.this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.consejo:
                intent =new Intent(Servicios.this, HORARIO.class);
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








