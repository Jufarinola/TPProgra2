package Dispositivos;

import GrafoVial.Interseccion;

public class Dispositivo {

    public String codigo;
    public boolean estado;
    public Interseccion ubicacion;

    public void activar() {
        estado = true;
    }

    public void desactivar() {
        estado = false;
    }

    public boolean consultarEstado() {
        return estado;
    }
}