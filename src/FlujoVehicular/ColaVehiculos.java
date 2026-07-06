package FlujoVehicular;

import Interfaces.IColaVehiculos;

public class ColaVehiculos implements IColaVehiculos {
    private NodoVehiculo primero;

    public ColaVehiculos() {
        this.primero = null;
    }

    public void encolar(Vehiculo v) {
        NodoVehiculo nuevo = new NodoVehiculo(v);

        if (estaVacia() || v.prioridad < primero.vehiculo.prioridad){
            nuevo.siguiente = primero;
            primero = nuevo;
        }
        else {
            NodoVehiculo aux = primero;

            while (aux.siguiente != null && aux.siguiente.vehiculo.prioridad <= v.prioridad){
                aux = aux.siguiente;
            }

            nuevo.siguiente = aux.siguiente;
            aux.siguiente = nuevo;
        }
    }

    public Vehiculo desencolar() {
        if (estaVacia()) {
            return null;
        }

        Vehiculo v = primero.vehiculo;
        primero = primero.siguiente;
        return v;
    }

    public boolean estaVacia() {
        return primero == null;
    }
}
