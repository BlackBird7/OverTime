package mx.edu.ittepic.juegoarturo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class login extends AppCompatActivity {
EditText usuario,contra;
//Button ingresar,nuevo;
ConexionWeb conexionWeb;
Button ingresar;
TextView etiqueta,registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // etiqueta = findViewById(R.id.txtetiquqeta);
        usuario= findViewById(R.id.edtusuario);
        contra= findViewById(R.id.edtcontra);
        registrar=findViewById(R.id.Registrar);

        ingresar=findViewById(R.id.btningresar);
       // nuevo=findViewById(R.id.btncrearnuevo);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirRegistro = new Intent(login.this,registro.class);
                startActivity(abrirRegistro);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conexionWeb= new ConexionWeb(login.this);
                conexionWeb.agregarVariables("usuario",usuario.getText().toString());
                conexionWeb.agregarVariables("contrasena",contra.getText().toString());

                try{
                    URL direccion = new URL("https://1234567abc.000webhostapp.com/Login.php");
                    conexionWeb.execute(direccion);
                }catch (MalformedURLException e){
                    Toast.makeText(login.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void validacion(String cadena){
        Intent abrirmenu = new Intent(login.this,menu.class);
        abrirmenu.putExtra("cadena",cadena);
        startActivity(abrirmenu);
    }


}
