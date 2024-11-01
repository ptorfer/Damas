package org.iesandalus.programacion.damas;

/*
Link github donde está el proyecto:
https://github.com/jma982/Damas/compare/main...ptorfer:Damas:main
*/

import org.iesandalus.programacion.damas.modelo.Color;
import org.iesandalus.programacion.damas.modelo.Dama;

public class MainApp {

    //Atributo de clase
    private static Dama dama;

    //Métodos
    public static void main(String[] args) {
    }

    private void ejecutarOpcion(int opcion){
        Consola.elegirOpcionMenu();
    }

    private void crearDamaDefecto(){
        dama= new Dama();
    }

    private void crearDamaColor(){
        Consola.elegirColor();
        Color color;
        color=Consola.elegirColor();
        dama=new Dama(color);
    }

}
