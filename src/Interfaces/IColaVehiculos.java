package Interfaces;

import FlujoVehicular.Vehiculo;

public interface IColaVehiculos {
    void encolar(Vehiculo v);
    Vehiculo desencolar();
    boolean estaVacia();
}
