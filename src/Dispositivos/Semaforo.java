package Dispositivos;

import GrafoVial.Interseccion;
import Interfaces.ISemaforo;
import FlujoVehicular.Vehiculo;

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

    public void liberarTrafico() {
        if (this.color.equals("Verde")) {
            if (!this.ubicacion.colaEspera.estaVacia()) {
                Vehiculo liberado = this.ubicacion.colaEspera.desencolar();
                System.out.println("Semáforo Verde: El vehículo " + liberado.patente + " avanzó y cruzó la intersección " + this.ubicacion.nombre + ".");
            } else {
                System.out.println("Semáforo Verde en " + this.ubicacion.nombre + " pero no hay autos esperando.");
            }
        } else {
            System.out.println("Semáforo Rojo en " + this.ubicacion.nombre + ": Los vehículos deben esperar.");
        }
    }
}