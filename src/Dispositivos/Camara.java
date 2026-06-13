package Dispositivos;

import GrafoVial.Interseccion;

public class Camara extends Dispositivo {

    public Camara(String codigo, Interseccion ubicacion) {

        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.estado = false;
    }
}