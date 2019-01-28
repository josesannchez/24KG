package facci.sanchezarteagajose.a2kg.Login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class HorarioRequest extends StringRequest {

        private static final String REGISTER_REQUEST_URL="https://movilintegrador.000webhostapp.com/c/reservacion.php";
        //AQUI CREO UN METODO PRIVADO STRING DE TIPO REGISTER_REQUEST_URL, EL CUAL TENDRÁ COMO DIRECCIÓN LA DEL ARCHIVO PHP REGISTER
        private Map<String,String> params;  //AQUI HAGO LOS PARAMETROS MAP PRIVADOS
        public HorarioRequest(String nombre, String fecha , String hora, String descripcion, Response.Listener<String> listener){
            //AQUI HAGO LAS VARIABLES QUE DESEO OBTENER DEL PHP
            super(Method.POST, REGISTER_REQUEST_URL,listener, null);
            params=new HashMap<>();
            params.put("nombre", nombre);
            params.put("fecha",fecha);   //TOMO NOMBRE
            params.put("hora",hora);
            params.put("descripcion", descripcion);//APELLIDO


        }

        @Override
        public Map<String, String> getParams() {
            return params;
        }
    }



