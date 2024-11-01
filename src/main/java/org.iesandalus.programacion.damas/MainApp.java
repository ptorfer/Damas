package org.iesandalus.programacion.damas;

/*
Link github donde está el proyecto:
https://github.com/jma982/Damas/compare/main...ptorfer:Damas:main
*/

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
        int opcionMenu=0;

        //Llamadas a métodos
        Consola.mostrarMenu();
        do{
            Consola.elegirOpcionMenu();
        }
        while (opcionMenu != 4);

        if (opcionMenu == 4){
            Consola.despedirse();
        }
    }

    private void ejecutarOpcion(int opcion){
        switch (opcion){
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

    private void crearDamaDefecto(){
        dama= new Dama();
    }

    private void crearDamaColor(){

        //Atributos:
        Color color;

        //Llamada a métodos y creación de objeto

        Consola.elegirColor();
        color = Consola.elegirColor();
        dama = new Dama(color);
    }

    private void mover(){

        //Atributos
        Direccion direccion;
        int pasos;

        //Llamada a métodos y creación de objeto
        try{
            Consola.mostrarMenuDirecciones();
            direccion=Consola.elegirDireccion();
            pasos=Consola.elegirPasos();
            dama.mover(direccion, pasos);
        }
        catch (OperationNotSupportedException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void mostrarDama(){

        Objects.requireNonNull(dama,"La dama no ha sido creada.");
        System.out.println(dama.toString());
    }
}


