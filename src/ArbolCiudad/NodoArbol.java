package ArbolCiudad;

import Interfaces.INodoArbol;

public class NodoArbol implements INodoArbol {
    String nombre;

    Manzana manzana;

    NodoArbol primerHijo;
    NodoArbol siguienteHermano;
    NodoArbol padre;

    int cantidadAccidentes;
    int cantidadInfracciones;
    int cantidadVehiculos;
    double puntajeCriticidad;

    public NodoArbol(String nombre){
        this.nombre = nombre;
        this.manzana = null;
        this.primerHijo = null;
        this.siguienteHermano = null;
        this.padre = null;
        this.cantidadAccidentes = 0;
        this.cantidadInfracciones = 0;
        this.cantidadVehiculos = 0;
        this.puntajeCriticidad = 0;
    }

    public NodoArbol(Manzana manzana){
        this.nombre = manzana.nombre;
        this.manzana = manzana;
        this.primerHijo = null;
        this.siguienteHermano = null;
        this.padre = null;
        this.cantidadAccidentes = 0;
        this.cantidadInfracciones = 0;
        this.cantidadVehiculos = 0;
        this.puntajeCriticidad = 0;
    }

    @Override
    public void mostrarNodo(){
        System.out.println(nombre);
    }

    public void calcularPuntajeCriticidad() {
        puntajeCriticidad =
                cantidadAccidentes * 50 +
                        cantidadInfracciones * 30 +
                        cantidadVehiculos * 10;
    }
}
