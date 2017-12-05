package mx.edu.ittepic.juegoarturo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by USUARIO on 31/10/2017.
 */

public class juego21 extends View {


    Bitmap p1,finish,a1,fondo,fondocarrera;
    int contador,contador2;
    int y,y2;
    CountDownTimer timer;
    boolean ganar,ini;
    menu m1;
    int points =0;
    int identificador=0;
    String ids,pts2;
    login updat;
    int nivel=1,nivelMaximoSesion=0,nivelMaximo,nivelPerdiste; //TODO recuperar el nivel maximo del usuario de la base de datos y compararlo cada ves que pierde

    public juego21(Context context,int p,int p2) {
        super(context);
        updat = new login();

        setPoints(p);
        Log.d("puuntuacion2", String.valueOf(points));

        setIdentificador(p2);

        ids = Integer.toString(identificador);
        pts2 = Integer.toString(points);






        contador =0;
        contador2=0;
        ganar=true;
        y=800;
        y2=800;
        ini=true;
        AlertDialog.Builder intro = new AlertDialog.Builder(context);
        intro.setTitle("Instrucciones");
        intro.setMessage("Tienes que llegar primero a la linea de meta,cuando presiones sobre la pantalla inicia la carrera,preciona repetidamente para correr y ganar");
        intro.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });intro.show();

        finish = BitmapFactory.decodeResource(getResources(),R.drawable.finish2);
        fondo = BitmapFactory.decodeResource(getResources(), R.drawable.fondo2);
        fondocarrera = BitmapFactory.decodeResource(getResources(), R.drawable.fondocarrera);
        p1 = BitmapFactory.decodeResource(getResources(), R.drawable.p1);
        a1= BitmapFactory.decodeResource(getResources(), R.drawable.a1);

        timer = new CountDownTimer(1000,50) {
            @Override
            public void onTick(long millisUntilFinished) {

                if(nivel==1){

                    contador2 +=1;
                    y2 -=4;
                    switch (contador2){
                        case 1:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a1);
                            break;
                        case 2:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a2);
                            break;
                        case 3:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a3);
                            break;
                        case 4:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a4);
                            break;
                        case 5:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a5);
                            break;
                        case 6:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a6);
                            break;
                        case 7:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a7);
                            break;
                        case 8:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a8);
                            break;
                        case 9:
                            contador2=0;
                            break;

                    }
                    invalidate();
                }

                if (nivel==2){


                    contador2 +=1;
                    y2 -=6;
                    switch (contador2){
                        case 1:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a1);
                            break;
                        case 2:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a2);
                            break;
                        case 3:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a3);
                            break;
                        case 4:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a4);
                            break;
                        case 5:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a5);
                            break;
                        case 6:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a6);
                            break;
                        case 7:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a7);
                            break;
                        case 8:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a8);
                            break;
                        case 9:
                            contador2=0;
                            break;

                    }
                    invalidate();
                }

                if (nivel==3){


                    contador2 +=1;
                    y2 -=8;
                    switch (contador2){
                        case 1:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a1);
                            break;
                        case 2:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a2);
                            break;
                        case 3:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a3);
                            break;
                        case 4:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a4);
                            break;
                        case 5:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a5);
                            break;
                        case 6:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a6);
                            break;
                        case 7:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a7);
                            break;
                        case 8:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a8);
                            break;
                        case 9:
                            contador2=0;
                            break;

                    }
                    invalidate();
                }

                if (nivel==4){


                    contador2 +=1;
                    y2 -=10;
                    switch (contador2){
                        case 1:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a1);
                            break;
                        case 2:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a2);
                            break;
                        case 3:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a3);
                            break;
                        case 4:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a4);
                            break;
                        case 5:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a5);
                            break;
                        case 6:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a6);
                            break;
                        case 7:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a7);
                            break;
                        case 8:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a8);
                            break;
                        case 9:
                            contador2=0;
                            break;

                    }
                    invalidate();
                }

                if (nivel==5){

                    contador2 +=1;
                    y2 -=12;
                    switch (contador2){
                        case 1:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a1);
                            break;
                        case 2:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a2);
                            break;
                        case 3:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a3);
                            break;
                        case 4:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a4);
                            break;
                        case 5:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a5);
                            break;
                        case 6:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a6);
                            break;
                        case 7:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a7);
                            break;
                        case 8:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a8);
                            break;
                        case 9:
                            contador2=0;
                            break;

                    }
                    invalidate();
                }

                if (nivel==6){
                    contador2 +=1;
                    y2 -=14;
                    switch (contador2){
                        case 1:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a1);
                            break;
                        case 2:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a2);
                            break;
                        case 3:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a3);
                            break;
                        case 4:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a4);
                            break;
                        case 5:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a5);
                            break;
                        case 6:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a6);
                            break;
                        case 7:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a7);
                            break;
                        case 8:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a8);
                            break;
                        case 9:
                            contador2=0;
                            break;

                    }
                    invalidate();
                }

                if (nivel==7){
                    contador2 +=1;
                    y2 -=16;
                    switch (contador2){
                        case 1:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a1);
                            break;
                        case 2:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a2);
                            break;
                        case 3:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a3);
                            break;
                        case 4:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a4);
                            break;
                        case 5:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a5);
                            break;
                        case 6:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a6);
                            break;
                        case 7:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a7);
                            break;
                        case 8:
                            a1= BitmapFactory.decodeResource(getResources(), R.drawable.a8);
                            break;
                        case 9:
                            contador2=0;
                            break;

                    }
                    invalidate();
                }

            }// fin

            @Override
            public void onFinish() {
                timer.start();

            }
        };




    }

    public boolean onTouchEvent (MotionEvent e){

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (ini==true){
                    timer.start();
                    ini=false;
                }
                y -=15;
                contador +=1;
                switch (contador){
                    case 1:
                        p1 = BitmapFactory.decodeResource(getResources(), R.drawable.p1);
                        break;
                    case 2:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p2);
                        break;
                    case 3:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p3);
                        break;
                    case 4:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p4);
                        break;
                    case 5:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p5);
                        break;
                    case 6:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p6);
                        break;
                    case 7:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p7);
                        break;
                    case 8:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p8);
                        break;
                    case 9:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p9);
                        break;
                    case 10:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p10);
                        break;
                    case 11:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p11);
                        break;
                    case 12:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p12);
                        break;
                    case 13:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p13);
                        break;
                    case 14:
                        p1= BitmapFactory.decodeResource(getResources(), R.drawable.p14);
                        break;
                    case 15:
                        contador=0;
                        break;
                }
                invalidate();

                break;
        }

        return true;
    }

    public void onDraw(Canvas c){
        Paint p = new Paint();


        p.setColor(Color.GRAY);
        c.drawRect(0,0,1200,1900,p);

        c.drawBitmap(fondocarrera,0,0,p);
        c.drawBitmap(fondo,-250,100,p);
        c.drawBitmap(finish,250,0,p);
        c.drawBitmap(p1,600,y,p);
        c.drawBitmap(a1,50,y2,p);

        //---------------------Gestion de puntos
        p.setColor(Color.BLUE);
        p.setTextSize(50);
        c.drawText("Nivel Actual:",50,80,p);
        c.drawText(""+nivel,140,140,p);

        c.drawText("puntuacion Max",600,80,p);
        c.drawText(""+points,690,160,p);

        if (y<100 && ganar==true){
            nivel=nivel+1;
            ganar=false;
            timer.cancel();
            AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
            alerta.setTitle("ATENCION!");
            alerta.setMessage("Felicidades Ganaste La Carrera");
            alerta.setPositiveButton("Siguiente Nivel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    y=950;
                    y2=1000;
                    ini=true;
                    dialog.dismiss();
                    ganar=true;

                }
            });
            alerta.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });
            alerta.show();


        }
        if (y2<100 && ganar==true){
            nivelPerdiste=nivel;
            nivel=1;
            ganar=false;
            timer.cancel();
            AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
            alerta.setTitle("ATENCION!");
            alerta.setMessage("Perdiste, nivel alcansado "+nivelPerdiste);
            alerta.setPositiveButton("Volver a Intentar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    y=950;
                    y2=1000;
                    ini=true;
                    dialog.dismiss();
                    ganar=true;



                }
            });
            alerta.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();


                }
            });
            alerta.show();



        }}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;

    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

}