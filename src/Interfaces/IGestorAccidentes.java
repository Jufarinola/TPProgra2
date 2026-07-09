package Interfaces;

import Accidentes.Accidente;

public interface IGestorAccidentes {
    double obtenerDemoraporAccidente(int posOrigen, int posDestino);
    Accidente reportarAccidente(int posOrigen, int posDestino, String gravedad);
    void resolverAccidente(int posOrigen, int posDestino);
}
