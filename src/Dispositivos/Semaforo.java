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

    public void liberarVehiculos(int cantidad) {

        for (int i = 0; i < cantidad; i++) {

            if (ubicacion.colaEspera.estaVacia()) {
                System.out.println("No hay más vehículos esperando.");
                return;
            }

            Vehiculo liberado = ubicacion.colaEspera.desencolar();

            System.out.println("Avanzó el vehículo: " + liberado.patente);
        }
    }

    public void cicloAutomatico(int ciclos) {

        for (int i = 1; i <= ciclos; i++) {

            System.out.println("\nCICLO " + i);

            cambiarAVerde();
            System.out.println("Semáforo " + codigo + " en VERDE");
            liberarVehiculos(3); // pasan 3 autos

            color = "Amarillo";
            System.out.println("Semáforo " + codigo + " en AMARILLO");

            cambiarARojo();
            System.out.println("Semáforo " + codigo + " en ROJO");
        }
    }
}