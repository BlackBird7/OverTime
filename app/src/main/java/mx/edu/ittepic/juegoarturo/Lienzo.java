package mx.edu.ittepic.juegoarturo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class Lienzo extends View {
    Figura c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,cmortal,ccontinuar,cperder;
    Bitmap gengar1,gengar2,gengar3,gastly1,fondo2,muerte,gengar300,gengar400,perder,ganar;
    boolean perdio=false;

    int bolas,x_perder=2000,y_perder=2000,x_ganar=-2000,y_ganar=-2000;

    public Lienzo(Context context) {
        super(context);
        Toast.makeText(getContext(), "No toques a Gengar ni a sus tinieblas o moriraaaas!!!!", Toast.LENGTH_LONG).show();

        //Los objetos  "c" van a tener las mismas variables que la clase Figura x,y,color,ancho,alto,etc
        c1 = new Figura(this);
        c2 = new Figura(this);
        c3 = new Figura(this);
        c4 = new Figura(this);
        c5 = new Figura(this);
        c6 = new Figura(this);
        c7 = new Figura(this);
        c8 = new Figura(this);
        c9 = new Figura(this);
        c10 = new Figura(this);
        c11 = new Figura(this);
        c12 = new Figura(this);
        c13 = new Figura(this);
        c14 = new Figura(this);
        c15 = new Figura(this);

        cmortal= new Figura(this);
        ccontinuar=new Figura(this);
        cperder=new Figura(this);


        gengar1= BitmapFactory.decodeResource(getResources(),R.drawable.gengar1);
        gengar2= BitmapFactory.decodeResource(getResources(),R.drawable.gengar2);
        gengar3= BitmapFactory.decodeResource(getResources(),R.drawable.gengar3);
        gengar300= BitmapFactory.decodeResource(getResources(),R.drawable.gengar300);
        gengar400= BitmapFactory.decodeResource(getResources(),R.drawable.gengar400);
        perder= BitmapFactory.decodeResource(getResources(),R.drawable.perder);
        ganar= BitmapFactory.decodeResource(getResources(),R.drawable.ganar);

        gastly1= BitmapFactory.decodeResource(getResources(),R.drawable.gastly);
        fondo2= BitmapFactory.decodeResource(getResources(),R.drawable.fondoprincipal);
        muerte= BitmapFactory.decodeResource(getResources(),R.drawable.muerte);
    }

    public void onDraw(Canvas c){
        Paint p = new Paint();

        //obtencion de total de pixeles
        int ancho_pantalla = c.getWidth();
        int alto_pantalla = c.getHeight();

        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(2);

        p.setColor(Color.BLACK);
        //Fondo               Izquierda,Arriba,Derecha,Abajo
        c.drawRect(0, 0, ancho_pantalla, alto_pantalla, p);


        //Fondo
        c.drawBitmap(fondo2,-120,0,p);

        // texto
        p.setColor(Color.CYAN);
        p.setTextSize(100);
        c.drawText("S U E R T E",ancho_pantalla/2-155,130,p);

        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.RED);
        p.setStrokeWidth(50);


        //bolas



        p.setColor(c1.color);
        c.drawCircle(c1.x,c1.y,c1.radio,p);

        p.setColor(c2.color);
        c.drawCircle(c2.x,c2.y,c2.radio,p);

        p.setColor(c3.color);
        c.drawCircle(c3.x,c3.y,c3.radio,p);

        p.setColor(c4.color);
        c.drawCircle(c4.x,c4.y,c4.radio,p);

        p.setColor(c5.color);
        c.drawCircle(c5.x,c5.y,c5.radio,p);

        p.setColor(c6.color);
        c.drawCircle(c6.x,c6.y,c6.radio,p);

        p.setColor(c7.color);
        c.drawCircle(c7.x,c7.y,c7.radio,p);

        p.setColor(c8.color);
        c.drawCircle(c8.x,c8.y,c8.radio,p);

        p.setColor(c9.color);
        c.drawCircle(c9.x,c9.y,c9.radio,p);

        p.setColor(c10.color);
        c.drawCircle(c10.x,c10.y,c10.radio,p);

        p.setColor(c11.color);
        c.drawCircle(c11.x,c11.y,c11.radio,p);

        p.setColor(c12.color);
        c.drawCircle(c12.x,c12.y,c12.radio,p);

        p.setColor(c13.color);
        c.drawCircle(c13.x,c13.y,c13.radio,p);

        p.setColor(c14.color);
        c.drawCircle(c14.x,c14.y,c14.radio,p);

        p.setColor(c15.color);
        c.drawCircle(c15.x,c15.y,c15.radio,p);

        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        c.drawCircle(cmortal.x_bola_mortal,cmortal.y_bola_mortal,cmortal.radio_bola_mortal,p);

        //imagenes

        //gengar
        c.drawBitmap(gengar300,cmortal.x_bola_mortal-180,cmortal.y_bola_mortal-200,p);

        //bola invisible que se hace grande cuando pierdes
        p.setColor(cperder.color);
        c.drawCircle(cperder.x,cperder.y,cperder.radioPerder,p);

        //imagen cuando pierde
        c.drawBitmap(perder,x_perder,y_perder,p);

        //imagen cuando gana
        c.drawBitmap(ganar,x_ganar,y_ganar,p);





    }

    //Codigo cuando preciona un circulo
    public  boolean onTouchEvent (MotionEvent e){
        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (c1.estaEnArea(x,y)==true) {

                    //  Toast.makeText(getContext(), "Eliminó c1", Toast.LENGTH_SHORT).show();
                    c1.color= Color.TRANSPARENT;
                    c1.radio=0;
                    bolas=bolas+1;
                }
                if (c2.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c2", Toast.LENGTH_SHORT).show();
                    c2.color= Color.TRANSPARENT;
                    c2.radio=0;
                    bolas=bolas+1;
                }
                if (c3.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminóc3", Toast.LENGTH_SHORT).show();
                    c3.color= Color.TRANSPARENT;
                    c3.radio=0;
                    bolas=bolas+1;
                }
                if (c4.estaEnArea(x,y)==true) {
                    //  Toast.makeText(getContext(), "Eliminó c4", Toast.LENGTH_SHORT).show();
                    c4.color= Color.TRANSPARENT;
                    c4.radio=0;
                    bolas=bolas+1;
                }
                if (c5.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c5", Toast.LENGTH_SHORT).show();
                    c5.color= Color.TRANSPARENT;
                    c5.radio=0;
                    bolas=bolas+1;
                }

                if (c6.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c6", Toast.LENGTH_SHORT).show();
                    c6.color= Color.TRANSPARENT;
                    c6.radio=0;
                    bolas=bolas+1;
                }

                if (c7.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c7", Toast.LENGTH_SHORT).show();
                    c7.color= Color.TRANSPARENT;
                    c7.radio=0;
                    bolas=bolas+1;
                }
                if (c8.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c8", Toast.LENGTH_SHORT).show();
                    c8.color= Color.TRANSPARENT;
                    c8.radio=0;
                    bolas=bolas+1;
                }

                if (c9.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c8", Toast.LENGTH_SHORT).show();
                    c9.color= Color.TRANSPARENT;
                    c9.radio=0;
                    bolas=bolas+1;
                }

                if (c10.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c8", Toast.LENGTH_SHORT).show();
                    c10.color= Color.TRANSPARENT;
                    c10.radio=0;
                    bolas=bolas+1;
                }

                if (c11.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c8", Toast.LENGTH_SHORT).show();
                    c11.color= Color.TRANSPARENT;
                    c11.radio=0;
                    bolas=bolas+1;
                }

                if (c12.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c8", Toast.LENGTH_SHORT).show();
                    c12.color= Color.TRANSPARENT;
                    c12.radio=0;
                    bolas=bolas+1;
                }

                if (c13.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c8", Toast.LENGTH_SHORT).show();
                    c13.color= Color.TRANSPARENT;
                    c13.radio=0;
                    bolas=bolas+1;
                }

                if (c14.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c8", Toast.LENGTH_SHORT).show();
                    c14.color= Color.TRANSPARENT;
                    c14.radio=0;
                    bolas=bolas+1;
                }

                if (c15.estaEnArea(x,y)==true) {
                    // Toast.makeText(getContext(), "Eliminó c8", Toast.LENGTH_SHORT).show();
                    c15.color= Color.TRANSPARENT;
                    c15.radio=0;
                    bolas=bolas+1;
                }

                    //Cuando da clic en Gengar o su bola

                if (cmortal.estaEnAreaMortal(x,y)==true) {
                  cmortal.color= Color.TRANSPARENT;
                    cmortal.radio=0;
                    cperder.radioPerder=1000;
                    cperder.color= Color.BLACK;

                    x_perder=-40;
                    y_perder=0;

                    //saber que ya perdio
                    perdio=true;
                }

                // CODIGO PARA SABER CUANDO GANA, SI CLIQUEA MAS DE 10 BOLAS GANA
                if((x>0 && y<1200)&& (perdio==false) && (bolas>14)){
                    Toast.makeText(getContext(), "Ganaste", Toast.LENGTH_LONG).show();
                    x_ganar=0;
                    y_ganar=0;
                }

                //codigo cuando pierde o gana y darle continuar

              /*  if((x>100 && x<700)&&(y>700 && y<1200)){

                }*/
                break;
        }
        return true;
    }



}

