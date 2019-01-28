package facci.sanchezarteagajose.a2kg.Login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class VehiculoRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="https://movilintegrador.000webhostapp.com/c/vehiculo.php";
    //AQUI CREO UN METODO PRIVADO STRING DE TIPO REGISTER_REQUEST_URL, EL CUAL TENDRÁ COMO DIRECCIÓN LA DEL ARCHIVO PHP REGISTER
    private Map<String,String> params;  //AQUI HAGO LOS PARAMETROS MAP PRIVADOS
    public VehiculoRequest(String marca, String modelo, String matricula, int age, Response.Listener<String> listener){
        //AQUI HAGO LAS VARIABLES QUE DESEO OBTENER DEL PHP
        super(Method.POST, REGISTER_REQUEST_URL,listener, null);
        params=new HashMap<>();
        params.put("marca",marca);   //TOMO NOMBRE
        params.put("modelo",modelo);
        params.put("matricula", matricula);//APELLIDO
        params.put("age",age+"");//CONTRAÑA


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
