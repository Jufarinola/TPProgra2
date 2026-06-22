package FlujoVehicular;

import Interfaces.IColaVehiculos;

public class ColaVehiculos implements IColaVehiculos {
    private NodoVehiculo frente;
    private NodoVehiculo fin;

    public ColaVehiculos() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(Vehiculo v) {
        NodoVehiculo nuevo = new NodoVehiculo(v);
        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Vehiculo desencolar() {
        if (frente == null) return null;

        Vehiculo v = frente.vehiculo;
        frente = frente.siguiente;

        if (frente == null) fin = null;

        return v;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
