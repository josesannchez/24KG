package facci.sanchezarteagajose.a2kg.Login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="https://movilintegrador.000webhostapp.com/c/Register.php";
    //AQUI CREO UN METODO PRIVADO STRING DE TIPO REGISTER_REQUEST_URL, EL CUAL TENDRÁ COMO DIRECCIÓN LA DEL ARCHIVO PHP REGISTER
    private Map<String,String> params;  //AQUI HAGO LOS PARAMETROS MAP PRIVADOS
    public RegisterRequest(String nombres, String apellidos, String cedula, String correo, String password, String verificacion, Response.Listener<String> listener){
        //AQUI HAGO LAS VARIABLES QUE DESEO OBTENER DEL PHP
        super(Method.POST, REGISTER_REQUEST_URL,listener, null);
        params=new HashMap<>();
        params.put("nombres",nombres);   //TOMO NOMBRE
        params.put("apellidos",apellidos);
        params.put("cedula", cedula);//APELLIDO
        params.put("correo", correo);
        params.put("password",password);  //CONTRAÑA
         //correo
        params.put("verificacion",verificacion);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
