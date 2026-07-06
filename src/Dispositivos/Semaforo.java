package Dispositivos;

import GrafoVial.Interseccion;
import Interfaces.ISemaforo;
import FlujoVehicular.Vehiculo;
import GrafoVial.Calle;
import Infraccion.GestorInfracciones;

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

    public void liberarTrafico(Calle calle, Camara camara, GestorInfracciones gestor) {

        if (this.color.equals("Verde")) {

            if (!this.ubicacion.colaEspera.estaVacia()) {

                Vehiculo liberado = this.ubicacion.colaEspera.desencolar();

                calle.agregarVehiculoEnCalle(liberado);

                System.out.println("Semáforo Verde: el vehículo "
                        + liberado.patente
                        + " salió de "
                        + this.ubicacion.nombre
                        + " y entró en "
                        + calle.nombre);

                camara.controlarVehiculo(liberado, calle, gestor);

            } else {
                System.out.println("No hay vehículos esperando en " + this.ubicacion.nombre);
            }

        } else {
            System.out.println("Semáforo Rojo: los vehículos deben esperar en " + this.ubicacion.nombre);
        }
    }


}