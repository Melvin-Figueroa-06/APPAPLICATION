package com.example.app_aplication.Utils;

import static com.google.android.gms.common.internal.ImagesContract.URL;

public class Data {
    public static String HOST = "http://172.21.0.1:8000";
    public static String REGISTER_SERVICE = HOST + "/v1.0/api/user";

    public static String ID_PERSONA_SERVICE = HOST + "/v1.0/api/user?id=";
    //REGISTRO USUARIO
    public static String LOGIN_SERVICE = HOST + "/v1.0/api/login";                      //lOGIN
    public static String TOKEN = "";

    public static String REGISTER_PUBLICACION = HOST + "/v1.0/api/publicacion";         //REGISTRO PUBLICACION
    public static String PUBLICADO_SERVICE = HOST + "/v1.0/api/publicacion";            //

    //public static String ;

    public static String USERS = HOST + "/v1.0/api/user";             //METODO GET USUARIO
    public static String ID_USER = "";

    public static String USERS_MODIFICADO = HOST + "/v1.0/api/user";


    public static String URL_PRODUCT = URL + "/v1.0/api/publicacion?id=";
    public static String ID_PRODUCTO_SERVICE = HOST + "/v1.0/api/publicacion?id=";
    public static String ID_PRODUCTO_IMAGE_SERVICE = HOST + "/producto/image?id=";
    public static String PRODUCTO_SERVICE = HOST +"/v1.0/api/publicacion";

    public static String SEGUIDOS_SERVICE = HOST +"/seguidos";
    public static String ID_SEGUIDOS_SERVICE = HOST + "/seguidos?id=";

    public static String ID_FAVORITO_SERVICE = HOST + "/favorito?id=";
    public static String FAVORITO_SERVICE = HOST +"/favorito";
    //token

    public static String ID_PUBLICACION = "";
    public static String ID = "";

    public static int startTab = 0;
}
