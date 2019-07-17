package com.example.app_aplication.Utils;

import static com.google.android.gms.common.internal.ImagesContract.URL;

public class Data {
    public static String HOST = "http://172.21.0.1:8000";
    public static String REGISTER_SERVICE = HOST + "/v1.0/api/user";                    //REGISTRO USUARIO
    public static String LOGIN_SERVICE = HOST + "/v1.0/api/login";                      //lOGIN
    public static String TOKEN = "";

    public static String REGISTER_PUBLICACION = HOST + "/v1.0/api/publicacion";         //REGISTRO PUBLICACION
    public static String PUBLICADO_SERVICE = HOST + "/v1.0/api/publicacion";            //

    //public static String ;

    public static String USERS = HOST + "/v1.0/api/user";             //METODO GET USUARIO
    public static String ID_USER = "";

    public static String USERS_MODIFICADO = HOST + "/v1.0/api/user";


    public static String URL_PRODUCT = URL + "/v1.0/api/publicacion";
    //token

    public static String ID_PUBLICACION = "";

}
