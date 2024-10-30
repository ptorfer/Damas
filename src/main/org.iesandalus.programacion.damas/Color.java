package org.iesandalus.programacion.damas;

public enum Color {
    BLANCO ("Blanco"),
    NEGRO ("Negro");

    private String cadenaAMostrar;

    private Color (String cadenaAMostrar){
        this.cadenaAMostrar=cadenaAMostrar;
    }

}
