package facci.sanchezarteagajose.a2kg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class adaptador2 extends BaseAdapter {
    private static LayoutInflater inflater = null;

    Context contexto2;
    String[][] datos2;
    int[] datosImg2;

    public adaptador2(Context conexto, String[][] datos, int[] imagenes)
    {
        this.contexto2 = conexto;
        this.datos2 = datos;//
        this.datosImg2 = imagenes;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista2 = inflater.inflate(R.layout.reparaciones, null);

        TextView titulo = (TextView) vista2.findViewById(R.id.tvNombre2);
        TextView duracion = (TextView) vista2.findViewById(R.id.tvPrecio2);


        ImageView imagen = (ImageView) vista2.findViewById(R.id.ivImagen2);


        titulo.setText(datos2[i][0]);
        duracion.setText("Precio " + datos2[i][2]);
        imagen.setImageResource(datosImg2[i]);


        imagen.setTag(i);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vist2 = new Intent(contexto2, vist2.class);
                vist2.putExtra("IMG", datosImg2[(Integer)v.getTag()]);
                contexto2.startActivity(vist2);
            }
        });


        return vista2;
    }

    @Override
    public int getCount() {
        return datosImg2.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
