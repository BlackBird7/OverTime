package mx.edu.ittepic.juegoarturo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ParaLienzo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));
    }
}
