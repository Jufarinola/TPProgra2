package Dispositivos;

import GrafoVial.Interseccion;
import Interfaces.IDispositivo;

public class Dispositivo implements IDispositivo {

    public String codigo;
    public boolean estado;
    public Interseccion ubicacion;

    @Override
    public void activar() {
        estado = true;
    }
    @Override
    public void desactivar() {
        estado = false;
    }
    @Override
    public boolean consultarEstado() {
        return estado;
    }
    @Override
    public void mostrarDispositivo(){
        System.out.println(codigo + " | " + ubicacion.nombre + " | Estado: " + estado);
    }

}