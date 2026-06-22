package Interfaces;

public interface IGestorAccidentes {
    double obtenerDemoraporAccidente(int posOrigen, int posDestino);
    void reportarAccidente(int posOrigen, int posDestino, String gravedad);
    void resolverAccidente(int posOrigen, int posDestino);
}
