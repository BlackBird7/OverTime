package mx.edu.ittepic.juegoarturo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView juego1,acerca_de,salir;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(new Lienzo (this));
        setContentView(R.layout.activity_principal);
        setTitle("Gengar Mortal");

        mp = MediaPlayer.create(this, R.raw.pokemon);
        mp.start();

        juego1=(TextView) findViewById(R.id.juego1);


        acerca_de=(TextView) findViewById(R.id.acerca_de);
        salir=(TextView) findViewById(R.id.salir);

        juego1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantallaJugar1= new Intent(Principal.this, ComoJugar.class);
                startActivity(pantallaJugar1);
            }
        });



        acerca_de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantallaAcercaDe = new Intent(Principal.this, AcercaDe2.class);
                startActivity(pantallaAcercaDe);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                finish();
            }
        });

}
}
