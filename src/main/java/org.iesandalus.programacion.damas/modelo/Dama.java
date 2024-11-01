package org.iesandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Dama {

    //Atributos
    Boolean esDamaEspecial=false;
    Color color;
    Posicion posicion;

    //Constructores
    public Dama(){
        this.color=Color.BLANCO;
        this.posicion=crearPosicionInicial();
    }

    public Dama(Color color) {
        this.color=color;
        this.posicion=crearPosicionInicial();
    }

    //Métodos
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color==Color.BLANCO || color==Color.NEGRO) {
            this.color = color;
        }
        else{
            throw new IllegalArgumentException("El color no es el esperado.");
        }
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion==getPosicion()){
            this.posicion = posicion;
        }
        else{
            throw new IllegalArgumentException("La posición no es la esperada.");
        }
    }

    public void mover (Direccion direccion, int pasos) throws OperationNotSupportedException {

        Objects.requireNonNull(direccion,"ERROR: La dirección no puede ser nula.");

        if (pasos>=1){
            int nuevaFila= getPosicion().getFila();
            char nuevaColumna= getPosicion().getColumna();

            if (!(esDamaEspecial)){
                if(pasos==1) {
                    if (color == Color.BLANCO) {
                        if (direccion == Direccion.NORESTE) {
                            nuevaFila = nuevaFila + pasos;
                            nuevaColumna = (char) (nuevaColumna + pasos);
                        }
                        if (direccion == Direccion.NOROESTE) {
                            nuevaFila = nuevaFila + pasos;
                            nuevaColumna = (char) (nuevaColumna - pasos);
                        }
                    }
                    //dama negra
                    else {
                        if (direccion == Direccion.SURESTE) {
                            nuevaFila = nuevaFila - pasos;
                            nuevaColumna = (char) (nuevaColumna + pasos);
                        }
                        if (direccion == Direccion.SUROESTE) {
                            nuevaFila = nuevaFila - pasos;
                            nuevaColumna = (char) (nuevaColumna - pasos);
                        }
                    }
                }//Si pasos !=1:
                else{
                    throw new OperationNotSupportedException("ERROR: Las damas normales solo se pueden mover 1 casilla.");
                }
            }
            //esDamaEspecial=true y pasos>=1
            else{
                if (color==Color.BLANCO) {
                    nuevaFila=8;
                }
                //dama negra:
                else{
                    nuevaFila=1;
                }
            }
            Posicion posicion = new Posicion(nuevaFila,nuevaColumna);
            setPosicion(posicion);
        }
        else{
            throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
        }
    }

    private Posicion crearPosicionInicial(){
        //Calculo posición inicial dama blanca de la fila
        int fila=0;
        if (getColor()== Color.BLANCO) {
            double aleatorio = Math.random();
            fila = (int) (aleatorio * 3) + 1;
        }

        //Calculo posición inicial dama negra de la fila
        if (getColor()==Color.NEGRO){
            double aleatorio = Math.random();
            fila = (int) (aleatorio * 3) + 6;
        }

        //Calculo posición inicial de columna (es la misma para dama negra y blanca)
        double aleatorio = Math.random();
        int c = (int) (aleatorio * 8) + 1;

        char columna = 'a';
        switch (c) {
            case 1:
                columna = 'a';
                break;
            case 2:
                columna = 'b';
                break;
            case 3:
                columna = 'c';
                break;
            case 4:
                columna = 'd';
                break;
            case 5:
                columna = 'e';
                break;
            case 6:
                columna = 'f';
                break;
            case 7:
                columna = 'g';
                break;
            case 8:
                columna = 'h';
                break;
            default: ;
        }

        Posicion posicionInicial= new Posicion(fila,columna);
        return posicionInicial;
    }

    @Override
    public String toString() {
        return String.format("Color [color=%s], Posicion [fila=%s, columna=%s]", this.getColor(), this.getPosicion().getFila(),getPosicion().getColumna());
    }
}
