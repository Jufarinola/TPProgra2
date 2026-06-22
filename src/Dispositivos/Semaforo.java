package Dispositivos;

import GrafoVial.Interseccion;
import Interfaces.ISemaforo;

public class Semaforo extends Dispositivo implements ISemaforo {

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