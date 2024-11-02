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
        Objects.requireNonNull(color,"ERROR: El color no puede ser nulo.");
        this.color=color;
        this.posicion=crearPosicionInicial();
    }

    //Métodos
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) throws OperationNotSupportedException {
        if (color==Color.BLANCO || color==Color.NEGRO) {
            this.color = color;
        }
        else{
            throw new OperationNotSupportedException("El color no es el esperado.");
        }
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = Objects.requireNonNull(posicion,"La posición no puede ser nula.");
    }

    public void mover (Direccion direccion, int pasos) throws OperationNotSupportedException {

        Objects.requireNonNull(direccion, "ERROR: La dirección no puede ser nula.");
        int nuevaFila = getPosicion().getFila();
        char nuevaColumna = getPosicion().getColumna();

        if ((nuevaFila == 8 && getColor() == Color.BLANCO) || (nuevaFila == 1 && getColor() == Color.NEGRO) || (esDamaEspecial)) {
            esDamaEspecial = true;
            if (pasos >= 1) {
                if (direccion == Direccion.NORESTE) {
                    nuevaFila = nuevaFila + pasos;
                    nuevaColumna = (char) (nuevaColumna + pasos);
                }
                if (direccion == Direccion.NOROESTE) {
                    nuevaFila = nuevaFila + pasos;
                    nuevaColumna = (char) (nuevaColumna - pasos);
                }
                if (direccion == Direccion.SURESTE) {
                    nuevaFila = nuevaFila - pasos;
                    nuevaColumna = (char) (nuevaColumna + pasos);
                }
                if (direccion == Direccion.SUROESTE) {
                    nuevaFila = nuevaFila - pasos;
                    nuevaColumna = (char) (nuevaColumna - pasos);
                }
            } else {
                throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
            }
        } else {
            if (pasos == 1) {
                if (color == Color.BLANCO) {
                    if (direccion == Direccion.NORESTE) {
                        nuevaFila = nuevaFila + pasos;
                        nuevaColumna = (char) (nuevaColumna + pasos);
                    }
                    else if (direccion == Direccion.NOROESTE) {
                        nuevaFila = nuevaFila + pasos;
                        nuevaColumna = (char) (nuevaColumna - pasos);
                    }
                    else{
                        throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
                    }
                }
                //Dama negra:
                else {
                    if (direccion == Direccion.SURESTE) {
                        nuevaFila = nuevaFila - pasos;
                        nuevaColumna = (char) (nuevaColumna + pasos);
                    }
                    else if (direccion == Direccion.SUROESTE) {
                        nuevaFila = nuevaFila - pasos;
                        nuevaColumna = (char) (nuevaColumna - pasos);
                    }
                    else{
                        throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
                    }
                }
            } else {
                throw new OperationNotSupportedException("ERROR: Las damas normales solo se pueden mover 1 casilla.");
            }
        }
        try {
            Posicion posicion = new Posicion(nuevaFila, nuevaColumna);
            setPosicion(posicion);
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException(e.getMessage());
        }
    }

    private Posicion crearPosicionInicial(){
        //Calculo posición inicial dama blanca de la fila
        int fila=1;
        if (getColor()== Color.BLANCO) {
            double aleatorio = Math.random();
            fila = (int) (aleatorio * 3) + 1;
        }

        //Calculo posición inicial dama negra de la fila
        if (getColor()==Color.NEGRO){
            double aleatorio = Math.random();
            fila = (int) (aleatorio * 3) + 6;
        }

        //Calculo posición inicial dama blanca de columna
        double aleatorio = Math.random();
        int c = (int) (aleatorio * 4) + 1;
        char columna='a';

        switch (fila) {
            case 1,3,7:
                if(c==1) {
                    columna = 'a';
                }
                else if(c==2){
                    columna = 'c';
                }
                else if(c==3){
                    columna = 'e';
                }
                else{
                    columna = 'g';
                }
                break;
            case 2,6,8:
                if(c==1) {
                    columna = 'b';
                }
                else if(c==2){
                    columna = 'd';
                }
                else if(c==3){
                    columna = 'f';
                }
                else{
                    columna = 'h';
                }
                break;
            default: ;
        }

        Posicion posicionInicial= new Posicion(fila,columna);
        return posicionInicial;
    }

    @Override
    public String toString() {
        return String.format("color=%s, posicion=(fila=%s, columna=%s)", this.getColor(), this.getPosicion().getFila(),getPosicion().getColumna());
    }
}
