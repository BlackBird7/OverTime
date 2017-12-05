package mx.edu.ittepic.juegoarturo;
import android.graphics.Color;
import android.os.CountDownTimer;


public class Figura {

    float x,y,radio;
    float x_bola_mortal,y_bola_mortal,radio_bola_mortal,radioPerder=0; //Variables de la bola mortal
    int movimiento_bola_mortal; //Mover aleatoriamente la bola

    CountDownTimer t;
    int color,nivel;
    boolean movimiento_x=true;
    boolean movimiento_y=true;

    public Figura(Lienzo v){

        //Asignacion de en que lugar van a estar las figuras
        x =(float) (Math.random()*700+200); //se genera del 0 al 99, en este caso el maximo alcanzable es 499
        y = (float) (Math.random()*1000+200);

        x_bola_mortal= 400;
        y_bola_mortal=400;
        radio_bola_mortal =100;


        //Asignacion de tamaños de las figuras de manera Ramdom
        radio = (int) (Math.random()*200+20);

        final Lienzo li= v;

        //Movimiento de las figuras
        t = new CountDownTimer(100,10) {

            //movimiento de las figuras por ejemplo, x=x+2
            @Override
            public void onTick(long millisUntilFinished) {

                //Velacidad de movimiento de las bolas segun su radio
                if(movimiento_x){
                    x=x+(1/radio)*1000;
                }else{
                    x=x-(1/radio)*1000;
                }

                //Saber cuando llega al límite de la pantalla las bolas
                if((x+radio>770 && movimiento_x==true)){
                    movimiento_x=false;}
                else{
                    if((x+-radio<30 && movimiento_x==false)){
                        movimiento_x=true;}

                //Movimiento Bola mortal, da un numero ramdom y segun eso es la direccion que le doy
                    //de ba ir lledo hacia abajo, por eso daré valores mas grandes hacia arriba
                    movimiento_bola_mortal=(int)(Math.random()*100);// puse 50 para que no cambiara tanto y quedaran 40 en dafault

                    switch (movimiento_bola_mortal){
                        case 0: x_bola_mortal=((int)(Math.random()*300)+x_bola_mortal); //movimiento ramdom hacia derecha
                            break;
                        case 1: x_bola_mortal=((int)(Math.random()*300)+x_bola_mortal);//Movimiento ramdon hacia arriba y derecha
                                y_bola_mortal=(int)(-(Math.random()*300)+y_bola_mortal);
                            break;
                        case 2: y_bola_mortal=(int)(-((Math.random()*300))+y_bola_mortal); //Movimiento ramdom hacia arriba
                            break;
                        case  3: x_bola_mortal=(int)(-((Math.random()*300))+x_bola_mortal); //movimiento ramdom hacia arriba e izquierda
                                 y_bola_mortal=(int)(-((Math.random()*300))+y_bola_mortal);
                            break;
                        case 4: x_bola_mortal=(int)(-((Math.random()*300))+x_bola_mortal); //Izquierda
                            break;
                        case 5: x_bola_mortal=(int)(-((Math.random()*300))+x_bola_mortal);//Izquierda abajo
                                y_bola_mortal=(int)((Math.random()*300)+y_bola_mortal);
                            break;
                        case 6: y_bola_mortal=(int)((Math.random()*300)+y_bola_mortal); //abajo
                            break;
                        case 7: y_bola_mortal=(int)((Math.random()*300)+y_bola_mortal); //abajo derecha
                                x_bola_mortal=((int)(Math.random()*300)+x_bola_mortal);
                            break;
                        //Cambiar los valores del radio, colores y velocidad cuando cambie de nivel
                        case 8: x_bola_mortal=x_bola_mortal-1;
                            break;
                        case 9: x_bola_mortal=x_bola_mortal-1;
                            break;
                        default: y_bola_mortal=y_bola_mortal+2;

                            //Si pega en un borde que se regrece haciaarriba
                            if(x_bola_mortal+radio_bola_mortal>1000 || x_bola_mortal-radio_bola_mortal <-200 || y_bola_mortal+radio_bola_mortal>1000 || y_bola_mortal<30){
                                x_bola_mortal=300;
                                y_bola_mortal=400;
                            }
                    }



                }
                li.invalidate();
            }

            @Override
            public void onFinish() {

                radio_bola_mortal=radio_bola_mortal+2;

                t.start();


            }
        };
        t.start();

        //Asignacion de los colores a cada figura de manera Ramdom, nos da un valor float pero se redondea a entero
        color = (int) (Math.random()*10);

        switch (color){
            case 0: color = Color.CYAN;
                break;
            case 1: color = Color.YELLOW;
                break;
            case 2: color = Color.YELLOW;
                break;
            case  3: color = Color.WHITE;
                break;
            case 4: color = Color.RED;
                break;
            case 5: color = Color.MAGENTA;
                break;
            case 6: color = Color.GRAY;
                break;
            case 7: color = Color.MAGENTA;
                break;
            case 8: color = Color.LTGRAY;
                break;
            case 9: color = Color.GREEN;
                break;
            default: color = Color.CYAN;
        }

    }

    //Saber cuando se toca una figura, xp y yp es el centro de la figura
    public boolean estaEnArea(float xp, float yp) {

        if (xp>x-radio && xp<x+radio  ) {
            if (yp>y-radio && yp<y+radio ) {
                return true;
            }
        }
        return false;
    }




    public boolean estaEnAreaMortal(float xp,float yp){
        if(xp>x_bola_mortal-radio_bola_mortal && xp<x_bola_mortal+radio_bola_mortal){
            if(yp>y_bola_mortal-radio_bola_mortal && yp<y_bola_mortal+radio_bola_mortal){
                return true;
            }
    }
        return false;
    }
}
