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
        int opcion;
        do{
            System.out.println("Introduzca una opción del menú.");
            opcion= Entrada.entero();
        }
        while (!(opcion>=1 && opcion<=4));
        return  opcion;
    }

    public static Color elegirColor(){
        int color;
        Color colorElegido;
        do{
            System.out.println("Introduzca un color: \n1.Blanco\n2.Negro");
            color=Entrada.entero();
            System.out.println(!(color==1 || color==2));
        }
        while (!(color==1 || color==2));

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
        int pasosElegidos;
        do{
            System.out.println("Introduzca un número de casillas mayor o igual a 1.");
            pasosElegidos= Entrada.entero();
        }
        while (!(pasosElegidos>=1));
        return  pasosElegidos;
    }

    public static Direccion elegirDireccion(){
        int d;
        Direccion direccionElegido=Direccion.NORESTE;
        do{
            mostrarMenuDirecciones();
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

    public static void despedirse(){
        System.out.println("¡Hasta pronto!");
    }
}
