package mx.edu.ittepic.juegoarturo;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FABRICAS on 21/11/2017.
 */

public class ConexionWeb extends AsyncTask<URL,String,String> {

    List<String[]> variables;
    login puntero;
    ProgressDialog dialogo;


    public ConexionWeb(login pp){
        puntero = pp;
        variables=new ArrayList<String[]>();
    }

    public void onPreExecute(){
        dialogo = ProgressDialog.show(puntero,"Procesando...","Conectando con servidor");
    }

    public void agregarVariables(String nombreVariable, String contenidoVariable) {
        String[]temporal = {nombreVariable, contenidoVariable};
        variables.add(temporal);
    }

    private String generarCadenaPost(){
        //nombre=emmanuel%20zambrano&domicilio=reforma%2040&sexo=masculino
        String post="";

        try{
            for(int i=0; i<variables.size(); i++) {
                String[] temporal = variables.get(i);
                post += temporal[0] + "=" + URLEncoder.encode(temporal[1], "UTF-8")+ " ";
                //      nombre                            emmanuel zambrano
            }
        }catch(Exception e){

        }
        post=post.trim();
        post=post.replaceAll(" ", "&");

        return post;
    }

    /*
    *  1. Crear el codigo de envio de variables (nombre,domicilio,sexo...)
    *  2. Abrir la conexion con el servidor Web (Remoto) es tu hosting
    *  3. Se envia las variables y valores convertidas en formato post
    *  4. Se revisa si fueron enviadas con exito, en cuyo caso se deberá esperar por la respuesta del servidor
    *  5. Se cierran conexion y se muestra la respuesta del servidor
    */



    @Override
    protected String doInBackground(URL... params) {
        // http://moviles-2017.000webhost.com/pagina.php
        String POST = generarCadenaPost();
        String respuesta = "";
        HttpURLConnection conexion = null;
        try{
            conexion = (HttpURLConnection) params[0].openConnection();

            conexion.setDoOutput(true); //Activa el metodo post
            conexion.setFixedLengthStreamingMode(POST.length());
            conexion.setRequestMethod("POST");

            //Creacion de flujo de salida
            OutputStream flujoSalida = new BufferedOutputStream(conexion.getOutputStream());
            flujoSalida.write(POST.getBytes()); // se manda a nivel de bytes
            flujoSalida.flush();
            flujoSalida.close();

            if (conexion.getResponseCode()==200){
                InputStreamReader entrada = new InputStreamReader(conexion.getInputStream(),"UTF-8");
                BufferedReader flujoEntrada = new BufferedReader(entrada);
                String temp="";
                do{
                    temp = flujoEntrada.readLine();
                    if (temp!=null){
                        respuesta+=temp;
                    }
                }while(temp!=null);
                flujoEntrada.close();

            }else {
                return "error_400";
            }

        }catch(UnknownHostException e){
            //Se dispara esta exepcion cuando escribiste mal la direccion WEB o tambien cuando el server se caiga
            dialogo.dismiss();
            respuesta="Error 404, corran perros voy a explotar";
        }catch (IOException e){
            //Se dispara cuando no se puede enviar o recibir datos
            dialogo.dismiss();
            respuesta="Error 405, corran perros voy a explotar";
        }finally {
            //Se ejecuta cuando todas las lineas de try se ejecutaron correctamente
            if (conexion!=null){
                conexion.disconnect();
            }
        }
        return respuesta;
    }

    public void onPostExecute(String r){
        dialogo.dismiss();


        if (r==""){
           // puntero.etiqueta.setText("no hay coincidencia");


        }else {
           // puntero.etiqueta.setText(r);
            puntero.validacion(r);
        }

    }



}
