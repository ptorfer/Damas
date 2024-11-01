package org.iesandalus.programacion.damas;

import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesandalus.programacion.damas.modelo.Color;
import org.iesandalus.programacion.damas.modelo.Direccion;

public class Consola {

    //Constructor
    private Consola(){}

    //Métodos
    public static void mostrarMenu(){
        System.out.println("1. Crear dama por defecto.");
        System.out.println("2. Crear dama eligiendo el color.");
        System.out.println("3. Mover.");
        System.out.println("4. Salir.");
    }

    public static int elegirOpcionMenu(){
        int opcionMenu;
        do{
            System.out.println("Introduzca una opción del menú.");
            opcionMenu= Entrada.entero();
        }
        while (!(opcionMenu>=1 && opcionMenu<=4));
        return  opcionMenu;
    }

    public static Color elegirColor(){
        int color;
        Color colorElegido=Color.BLANCO;
        do{
            System.out.println("Introduzca un color: \n1.Blanco\2.Negro");
            color=Entrada.entero();
        }
        while (color!=1 && color!=2);

        if (color==1){
            colorElegido=Color.BLANCO;
        }
        else{
            colorElegido=Color.NEGRO;
        }
    return colorElegido;
    }

    public static void mostrarMenuDirecciones(){
        System.out.println("1. Noreste.");
        System.out.println("2. Sureste.");
        System.out.println("3. Suroeste.");
        System.out.println("4. Noroeste.");
    }

    public static int elegirPasos(){

    }

    public static Direccion elegirDireccion(){
        int d;
        Direccion direccionElegido=Direccion.NORESTE;
        do{
            System.out.println("Introduzca una direccion: \n1.Noreste \n2.Sureste \n3.Suroeste \n4.Noroeste");
            d=Entrada.entero();
        }
        while (!(d>=1 && d<=4));

        switch (d){
            case 1:
                direccionElegido= Direccion.NORESTE;
                break;

            case 2:
                direccionElegido= Direccion.SURESTE;
                break;

            case 3:
                direccionElegido= Direccion.SUROESTE;
                break;

            case 4:
                direccionElegido= Direccion.NOROESTE;
                break;
            default: ;
        }
        return direccionElegido;
    }
}
