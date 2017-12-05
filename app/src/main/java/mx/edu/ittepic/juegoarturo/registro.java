package mx.edu.ittepic.juegoarturo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class registro extends AppCompatActivity {

    EditText nombre,contraseña;
    Button registrar;
    ConexionWeb conexionweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre=findViewById(R.id.nombre);
        contraseña=findViewById(R.id.contraseña);
        registrar=findViewById(R.id.registrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conexionweb= new ConexionWeb(this);

                // antes de conectar se agregan variables
                conexionweb.agregarVariables("nombre",nombre.getText().toString());
                conexionweb.agregarVariables("contraseña",contraseña.getText().toString());

                try{
                    URL direccion = new URL("https://blackbird.000webhostapp.com/recibirvariables.php");
                    conexionweb.execute(direccion);
                }catch (MalformedURLException e){
                    Toast.makeText(registro.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}