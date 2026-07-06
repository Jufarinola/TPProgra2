package Dispositivos;

import GrafoVial.Interseccion;
import FlujoVehicular.Vehiculo;
import GrafoVial.Calle;
import Infraccion.GestorInfracciones;
import Infraccion.Infraccion;

public class Camara extends Dispositivo {
    public Camara(String codigo, Interseccion ubicacion) {

        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.estado = false;
    }


    public void controlarVehiculo(Vehiculo vehiculo, Calle calle, GestorInfracciones gestor) {

        if (!estado) {
            System.out.println("La cámara " + codigo + " está apagada.");
            return;
        }

        if (vehiculo.velocidadActual > calle.limiteVelocidad) {

            Infraccion infraccion = new Infraccion(
                    vehiculo.patente,
                    "Exceso de velocidad",
                    calle.nombre,
                    50000
            );

            gestor.registrarInfraccion(infraccion);

        } else {
            System.out.println("Vehículo " + vehiculo.patente + " dentro del límite permitido.");
        }
    }
}