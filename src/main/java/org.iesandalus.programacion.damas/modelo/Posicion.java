package org.iesandalus.programacion.damas.modelo;

import java.util.Objects;


public class Posicion {

    //Atributos
    int fila;
    char columna;

    //Constructores
    public Posicion (int fila,char columna){
        setFila(fila);
        setColumna(columna);
    }

    public Posicion (Posicion posicion){
        Objects.requireNonNull(posicion,"ERROR: No es posible copiar una posición nula.");
        fila=posicion.fila;
        columna=posicion.columna;
    }

    //Métodos
    private void setFila (int fila){
        if (fila >=1 && fila <=8){
            this.fila=fila;
        }
        else{
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }
    }

    public int getFila() {
        return fila;
    }

    private void setColumna (char columna){
        if (columna >= 'a' && columna <= 'h'){
            this.columna=columna;
        }
        else{
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }
    }

    public char getColumna (){
        return columna;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicion posicion2)) return false;
        return fila == posicion2.fila && columna == posicion2.columna;
    }
}
