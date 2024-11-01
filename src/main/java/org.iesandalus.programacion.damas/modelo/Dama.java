package org.iesandalus.programacion.damas.modelo;

public class Dama {

    //Atributos
    Boolean esDamaEspecial;
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
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
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
}
