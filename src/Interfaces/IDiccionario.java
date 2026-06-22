package Interfaces;

import Dispositivos.Dispositivo;

public interface IDiccionario {
    void agregar(Dispositivo dispositivo);
    Dispositivo buscar(String codigo);
    void mostrar();
}
