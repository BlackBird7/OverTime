package mx.edu.ittepic.juegoarturo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class juego2 extends AppCompatActivity {
    String p1,ide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p1 = getIntent().getExtras().getString("puntos2");
        int pp = Integer.parseInt(p1);
        ide = getIntent().getExtras().getString("id");
        int ppp = Integer.parseInt(ide);
        setContentView(new juego21(this,pp,ppp));


    }



}
