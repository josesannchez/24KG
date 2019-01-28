package facci.sanchezarteagajose.a2kg.Login;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL="https://movilintegrador.000webhostapp.com/c/Login.php";
    /*AQUI HAGO UN PRIVATE STATIC FINAL DE TIPO STRING LOGIN REQUEST CON LA URL DEL ARCHIVO LOGIN QUE ES EN DONDE TENEMOS EL ARCHIVO PHP LOGIN
    QUE ESTE SE ENCARGARÁ DE HACER EL INGRESO AL SISTEMA*/

    private Map<String,String> params; //AQUI HAGO UN PRIVATE MAP DE TIPO STRING PARA QUE TOME LOS PARÁMETROS
    public LoginRequest(String correo, String password, Response.Listener<String> listener){ /*AQUI HAGO UN LOGINREQUEST CON LAS VARIABLES
        RUT Y PASSWORD Y HACEMOS EL RESPONSE LISTENER QUE ES EL ESCUCHADOR*/
        super(Request.Method.POST, LOGIN_REQUEST_URL,listener, null); //AQUI YA TENEMOS EL METODO POST QUE TOMA EL VALOR DE LAS VARIABLES
        params=new HashMap<>(); //AQUI HAGO UN PARAMETRO DE HASHMAP
        params.put("correo", correo); //AQUI DIGO TOMO LOS PARAMETROS DEL PHP
        params.put("password",password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;  //POR ÚLTIMO TOMO TODOS LOS PARAMETROS
    }
}
