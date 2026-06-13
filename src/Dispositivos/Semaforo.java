package Dispositivos;

import GrafoVial.Interseccion;

public class Semaforo extends Dispositivo {

    public String color;

    public Semaforo(String codigo, Interseccion ubicacion) {

        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.estado = false;
        this.color = "Rojo";
    }

    public void cambiarAVerde() {
        color = "Verde";
    }

    public void cambiarARojo() {
        color = "Rojo";
    }
}