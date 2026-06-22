package GrafoVial;

import FlujoVehicular.ColaVehiculos;
import FlujoVehicular.Vehiculo;

public class Interseccion {
    public String nombre;
    public ColaVehiculos colaEspera; 

    public Interseccion(String nombre){
        this.nombre = nombre;
        this.colaEspera = new ColaVehiculos();
    }

    public void llegarVehiculo(Vehiculo v) {
        colaEspera.encolar(v);
        System.out.println("Auto " + v.patente + " llegó a " + nombre);
    }
}
