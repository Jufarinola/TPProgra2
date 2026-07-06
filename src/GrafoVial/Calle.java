package GrafoVial;

import FlujoVehicular.NodoVehiculo;
import FlujoVehicular.Vehiculo;

public class Calle {
    public String nombre;
    int altura;

    Interseccion origen;
    Interseccion destino;

    int distancia;
    public int limiteVelocidad;

    public NodoVehiculo primeroVehiculo;

    public Calle(String nombre, int altura,
                 Interseccion origen, Interseccion destino,
                 int distancia, int limiteVelocidad) {

        this.nombre = nombre;
        this.altura = altura;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.limiteVelocidad = limiteVelocidad;
        this.primeroVehiculo = null;
    }

    public void agregarVehiculoEnCalle(Vehiculo vehiculo) {
        NodoVehiculo nuevo = new NodoVehiculo(vehiculo);

        if (primeroVehiculo == null) {
            primeroVehiculo = nuevo;
        } else {
            NodoVehiculo aux = primeroVehiculo;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
        }

    }

    public void mostrarVehiculosEnCalle() {
        if (primeroVehiculo == null) {
            System.out.println("No hay vehículos circulando en " + nombre);
            return;
        }

        NodoVehiculo aux = primeroVehiculo;

        while (aux != null) {
            System.out.println(aux.vehiculo.patente + " - Velocidad: " + aux.vehiculo.velocidadActual + " km/h");
            aux = aux.siguiente;
        }
    }


}
