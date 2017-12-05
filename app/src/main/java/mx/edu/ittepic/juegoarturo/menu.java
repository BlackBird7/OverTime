package mx.edu.ittepic.juegoarturo;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class menu extends AppCompatActivity {
    MediaPlayer mp;
    String respuesta;
    ConexionWeb conexionWeb;
    TextView titulo;
    String puntuacion1,puntuacion2,puntuacion3,id;

    Button j1,j2,j3,ad,slr,prueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        respuesta = getIntent().getExtras().getString("cadena");
        String[] separado = respuesta.split("/");
        id=separado[0];
        puntuacion1=separado[1];
        puntuacion2=separado[2];
        puntuacion3=separado[3];


        titulo = findViewById(R.id.txttitulo);
        prueba = findViewById(R.id.btnprueba);
        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titulo.setText(id);
            }
        });



        mp = MediaPlayer.create(this, R.raw.musica1);
        mp.start();

        j1= (Button) findViewById(R.id.J1);
        j2= (Button) findViewById(R.id.J2);
        j3= (Button) findViewById(R.id.J3);
        ad = (Button) findViewById(R.id.AD);
        slr = (Button) findViewById(R.id.SLR);

    }
    public void juego1(View v){

        Intent j1 = new Intent(menu.this,juego1.class);
        startActivity(j1);
    }
    public void juego2(View v){


        Intent j2 = new Intent(menu.this,juego2.class);
        j2.putExtra("puntos2",puntuacion2);
        j2.putExtra("id",id);
        startActivity(j2);


    }
    public void juego3(View v){
        mp.stop();
        Intent j3 = new Intent(menu.this,Principal.class);
        startActivity(j3);
    }
    public void acercaDe(View v){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        alerta.setTitle("Acerca de").setMessage("Esta aplicacion fue hecha por: \nIvan *Leobardo Estrada Salinas\nArturo *Misael Escalante Licona\n *Calos E. Zambrano Cortez")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alerta.show();
    }
    public void salir(View v){
        final AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        alerta.setTitle("¡ Atencion !").setMessage("¿ Desea Salir de la Aplicación?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        dialogInterface.dismiss();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        alerta.show();
    }
}
