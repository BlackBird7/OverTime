package mx.edu.ittepic.juegoarturo;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by USUARIO on 31/10/2017.
 */

public class juego11 extends View {
    boolean modoPelea;
    int ancho, alto, pkl,sqll,x1,y1,pp;
    Bitmap pika,sql,normal,electrico,especial;



    public juego11(Context context) {
        super(context);

        modoPelea=false;
        pp=10;
        ancho=1080;
        alto=1920;
        pkl=100;
        sqll=100;
        x1=1000;
        y1=490;
        pika = BitmapFactory.decodeResource(getResources(),R.drawable.pika);
        sql = BitmapFactory.decodeResource(getResources(),R.drawable.squirtle);
        normal= BitmapFactory.decodeResource(getResources(),R.drawable.normal);
        electrico= BitmapFactory.decodeResource(getResources(),R.drawable.electrico);
        especial= BitmapFactory.decodeResource(getResources(),R.drawable.especial);
    }
    public void onDraw(Canvas c){
        Paint p = new Paint();

        //Inicio Abajo---------------------------------------------------------------------------
        p.setColor(Color.WHITE);
        c.drawRect(0,860,ancho,alto,p);
        //Boton Pelea
        if(modoPelea==false) {
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.RED);
            c.drawRect(150, 960, 950, 1460, p);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            p.setStrokeWidth(8);
            c.drawRect(150, 960, 950, 1460, p);

            p.setTextSize(50);
            p.setColor(Color.BLACK);
            c.drawText("PELEAR",450,1220,p);
            //------------------------------------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);
            c.drawRect(300,1600,780,1920,p);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            p.setStrokeWidth(8);
            c.drawRect(300,1600,780,1920,p);
            p.setTextSize(50);
            p.setColor(Color.BLACK);
            c.drawText("SALIR",460,1710,p);

        } else {
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.WHITE);
            c.drawRect(0,860,1080,1920,p);

            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);
            c.drawRect(300,1600,780,1920,p);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            p.setStrokeWidth(8);
            c.drawRect(300,1600,780,1920,p);
            p.setTextSize(50);
            p.setColor(Color.BLACK);
            c.drawText("REGRESAR",410,1710,p);

            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.RED);
            c.drawRect(100, 960, 480, 1210, p);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            p.setStrokeWidth(8);
            c.drawRect(100, 960, 480, 1210, p);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.WHITE);
            c.drawRect(120, 980, 460, 1190, p);
            p.setColor(Color.BLACK);
            c.drawText("Embestida",170,1050,p);
            c.drawText(pp+"/10",320,1130,p);
            c.drawBitmap(normal,130,1080,p);

            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.RED);
            c.drawRect(550, 960, 930, 1210, p);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            p.setStrokeWidth(8);
            c.drawRect(550, 960, 930, 1210, p);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.WHITE);
            c.drawRect(570, 980, 910, 1190, p);
            p.setColor(Color.BLACK);
            c.drawText("Impactrueno",600,1050,p);
            c.drawText(pp+"/10",770,1130,p);
            c.drawBitmap(electrico,580,1080,p);

            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.RED);
            c.drawRect(350, 1260, 730, 1510, p);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            p.setStrokeWidth(8);
            c.drawRect(350, 1260, 730, 1510, p);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.WHITE);
            c.drawRect(370, 1280, 710, 1490, p);
            p.setColor(Color.BLACK);
            c.drawText("Embolia",420,1350,p);
            c.drawText(pp+"/10",570,1430,p);
            c.drawBitmap(especial,380,1380,p);
        }

        //Inicio Arriba-------------------------------------------------------------------------
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(8);
        c.drawRect(0,660,1080,860,p);

        p.setTextSize(50);
        p.setColor(Color.BLACK);
        c.drawText("¿Que Deberia Hacer Pikachu?",100,780,p);

        c.drawBitmap(pika,20,235,p);
        c.drawBitmap(sql,770,0,p);
        //Vida de Pikachu-----------------------------------------------------------------------
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        c.drawRect(520,400,1040,600,p);

        p.setTextSize(40);
        p.setColor(Color.BLACK);
        c.drawText("Pikachu",550,470,p);

        p.setTextSize(40);
        p.setColor(Color.BLACK);
        c.drawText("LV. 100",880,470,p);
        // ----------
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.GREEN);
        c.drawRect(680,500,x1,530,p);

        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(4);
        c.drawRect(680,500,1000,530,p);
        // ----------
        p.setTextSize(40);
        p.setColor(Color.BLACK);
        c.drawText(pkl+" / 100",850,580,p);
        //Vida de Squirtle----------------------------------------------------------------------
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(8);
        c.drawRect(10,10,530,210,p);

        p.setTextSize(40);
        p.setColor(Color.BLACK);
        c.drawText("Squirtle",40,80,p);

        p.setTextSize(40);
        p.setColor(Color.BLACK);
        c.drawText("LV. 100",370,80,p);
        //--------
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.GREEN);
        p.setStrokeWidth(4);
        c.drawRect(170,110,y1,140,p);

        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        c.drawRect(170,110,490,140,p);
        // -------
        p.setTextSize(40);
        p.setColor(Color.BLACK);
        c.drawText(sqll+" / 100",340,190,p);
    }

    public boolean onTouchEvent(MotionEvent me){
        float xPantalla, yPantalla;

        xPantalla=me.getX();
        yPantalla=me.getY();

        switch (me.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (pelear(xPantalla,yPantalla)){ //boton pelear
                    modoPelea = true;
                    invalidate();
                    if (embestida(xPantalla,yPantalla)){ //boton Embestida
                        if (modoPelea=true) {
                            sqll = sqll - 20;
                            y1=y1-65;
                            pkl=pkl-15;
                            x1=x1-60;
                            if (sqll<=0 && pkl>0){
                                AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
                                alerta.setTitle("FELICIDADES!").setMessage("Ganaste la Batalla,Squirtle ha caido\n\nSquirtle: Vamo a Calmarno :(")
                                        .setPositiveButton("Seguir", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                y1=490;
                                                x1=1000;
                                                sqll=100;
                                                pkl=100;
                                                invalidate();
                                                dialogInterface.dismiss();
                                            }
                                        }); alerta.show();
                            }
                            modoPelea = false;
                        }
                    }
                    if (impactrueno(xPantalla,yPantalla)){ //boton Impactrueno
                        if (modoPelea=true) {
                            sqll = sqll - 40;
                            y1=y1-100;
                            modoPelea = false;
                            if (sqll<=0 && pkl>0){
                                AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
                                alerta.setTitle("FELICIDADES!").setMessage("Ganaste la Batalla, Squirtle ha caido\n\nSquirtle: Vamo a Calmarno :(")
                                        .setPositiveButton("Seguir", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                y1=490;
                                                x1=1000;
                                                sqll=100;
                                                pkl=100;
                                                invalidate();
                                                dialogInterface.dismiss();
                                            }
                                        }); alerta.show();
                            }
                        }
                    }
                    if (especial(xPantalla,yPantalla)){ //boton Embolia
                        if (modoPelea=true) {
                            pkl = pkl - 100;
                            x1=x1-320;
                            if (sqll>0 && pkl==0){
                                AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
                                alerta.setTitle("Has Perdido :C").setMessage("Usaste Embolia Cerebral, Pikachu a muerto :c")
                                        .setPositiveButton("Seguir", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                y1=490;
                                                x1=1000;
                                                sqll=100;
                                                pkl=100;
                                                invalidate();
                                                dialogInterface.dismiss();
                                            }
                                        }); alerta.show();
                            }
                            modoPelea = false;

                        }
                    }
                    if (regresar(xPantalla,yPantalla)){ //boton Regresar
                        if (modoPelea=true) {
                            modoPelea = false;
                        }

                    }invalidate();
                    if (salir(xPantalla,yPantalla)){

                    }
                    break;
                }
        }return true;
    }
    public boolean pelear(float xP, float yP){
        if (xP>150 && xP<950){
            if (yP>960 && yP<1460){
                return true;
            }
        }
        return false;
    }
    public boolean salir(float xP, float yP){
        if (xP>300 && xP<780){
            if (yP>1600 && yP<1920){
                return true;
            }
        }
        return false;
    }
    public boolean embestida(float xP, float yP){
        if (xP>100 && xP<480){
            if (yP>960 && yP<1210){
                return true;
            }
        }
        return false;
    }
    public boolean impactrueno(float xP, float yP){
        if (xP>550 && xP<930){
            if (yP>960 && yP<1210){
                return true;
            }
        }
        return false;
    }
    public boolean especial(float xP, float yP){
        if (xP>350 && xP<730){
            if (yP>1260 && yP<1510){
                return true;
            }
        }
        return false;
    }
    public boolean regresar(float xP, float yP){
        if (xP>300 && xP<780){
            if (yP>1600 && yP<1920){
                return true;
            }
        }
        return false;
    }
}