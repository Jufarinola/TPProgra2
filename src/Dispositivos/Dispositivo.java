package Dispositivos;

import GrafoVial.Interseccion;
import Interfaces.IDispositivo;
import reportes.RegistroEventos;

public class Dispositivo implements IDispositivo {

    public String codigo;
    public boolean estado;
    public Interseccion ubicacion;

    @Override
    public void activar() {
        estado = true;

        RegistroEventos.registrar(
                "DISPOSITIVO",
                "Se activó el dispositivo " + codigo,
                this);

    }
    @Override
    public void desactivar() {
        estado = false;

        RegistroEventos.registrar(
                "DISPOSITIVO",
                "Se desactivó el dispositivo " + codigo,
                this
        );

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