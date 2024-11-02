package org.iesandalus.programacion.damas;

/*
Link github donde está el proyecto:
https://github.com/jma982/Damas/compare/main...ptorfer:Damas:main
*/

import jdk.dynalink.Operation;
import org.iesandalus.programacion.damas.modelo.Color;
import org.iesandalus.programacion.damas.modelo.Dama;
import org.iesandalus.programacion.damas.modelo.Direccion;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class MainApp {


    //Atributo de clase
    private static Dama dama;

    //Métodos
    public static void main(String[] args) {

        //Atributo
        int opcion;

            //Llamadas a métodos
            do {
                Consola.mostrarMenu();
                opcion = Consola.elegirOpcionMenu();
                ejecutarOpcion(opcion);
            }
            while (opcion != 4);
    }

    private static void ejecutarOpcion(int opcion){

        switch (opcion) {
            case 1:
                crearDamaDefecto();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                Consola.despedirse();
                break;
            default: ;
        }
    }

    private static void crearDamaDefecto(){
        dama= new Dama();
        mostrarDama();
    }

    private static void crearDamaColor(){

        //Atributos:
        Color color;

        //Llamada a métodos y creación de objeto

        color = Consola.elegirColor();
        dama = new Dama(color);
        mostrarDama();
    }

    private static void mover(){

        //Atributos
        Direccion direccion;
        int pasos;

        try{
            //Llamada a métodos

                Objects.requireNonNull(dama,"La dama no ha sido creada.");
                direccion=Consola.elegirDireccion();
                pasos=Consola.elegirPasos();
                dama.mover(direccion, pasos);
                mostrarDama();
        }
        catch (OperationNotSupportedException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarDama(){

        Objects.requireNonNull(dama,"La dama no ha sido creada.");
        System.out.println(dama.toString());
    }
}


