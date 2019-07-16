package com.example.app_aplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_aplication.Utils.Data;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import dmax.dialog.SpotsDialog;

public class Iniciar_Sesion extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {


    EditText emailEdit, passwordEdit;
    Button loginButton, registerButton;

    private static final int PERMISSION_SIGN_IN = 9999; // Any integer value you want
    GoogleApiClient mGoogleApiClient;
    SignInButton signInButton;
    FirebaseAuth firebaseAuth;

    //Create Dialog
    AlertDialog waiting_dialog;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PERMISSION_SIGN_IN){

            waiting_dialog.show();

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()){

                waiting_dialog.dismiss();

                GoogleSignInAccount account = result.getSignInAccount();
                String idToken = account.getIdToken();

                AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
                firebaseAuthWithGoogle(credential);
            }
            else{

                waiting_dialog.dismiss();

                Log.e("ERROR", "Login Failed");
                Log.e("error", result.getStatus().getStatusMessage());
            }
        }

    }

    private void firebaseAuthWithGoogle(AuthCredential credential) {
        firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //Start new activity and pass email to new activity
                        Intent intent = new Intent(Iniciar_Sesion.this,DrawerActivity.class);
                        intent.putExtra("email", authResult.getUser().getEmail());
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Iniciar_Sesion.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar__sesion);

        loadComponents();

        configureGoogleSignIn();

        firebaseAuth = FirebaseAuth.getInstance();

        signInButton = (SignInButton)findViewById(R.id.google_sign_in);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        waiting_dialog = new SpotsDialog.Builder().setContext(this)
                .setMessage("Por favor...")
                .setCancelable(false)
                .build();
    }

    private void loadComponents() {

        emailEdit = findViewById(R.id.email);
        passwordEdit = findViewById(R.id.password);

        loginButton = findViewById(R.id.login);
        registerButton = findViewById(R.id.registrarse);

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    private void signIn() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(intent, PERMISSION_SIGN_IN);
    }

    private void configureGoogleSignIn() {
        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, options)
                .build();
        mGoogleApiClient.connect();
    }



    private void login() {

        //controlar no vacios
        final EditText emails = findViewById(R.id.email);
        final EditText passwords = findViewById(R.id.password);
        final TextView welcome = findViewById(R.id.welcome);
        welcome.setVisibility(View.GONE);

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("email", emails.getText().toString());
        params.add("password", passwords.getText().toString());

        client.post(Data.LOGIN_SERVICE, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            if (response.has("token")){
                try {
                    Data.TOKEN = response.getString("token");
                    Toast.makeText(Iniciar_Sesion.this,"Usuario Logueado con Exito",Toast.LENGTH_LONG).show();
                    welcome.setVisibility(View.VISIBLE);
                    welcome.setText("BIEN VENIDO AHORA PUEDES COMPRAR Y VENDER" + emails.getText());
                    emails.setVisibility(View.GONE);
                    passwords.setVisibility(View.GONE);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            }
        });


    }
    private void register() {
        Intent registerIntent = new Intent(this, Registrandose.class);
        startActivity(registerIntent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login){
            login();
        }else{
            register();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, ""+connectionResult.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }
}