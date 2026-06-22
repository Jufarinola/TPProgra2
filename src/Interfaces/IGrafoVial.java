package Interfaces;

import GrafoVial.Calle;
import GrafoVial.Interseccion;

public interface IGrafoVial {
    void agregarInterseccion(Interseccion interseccion);
    int obtenerIndice(Interseccion interseccion);
    void insertarCalle(Calle calle);
    void eliminarInterseccion(Interseccion interseccion);
    void eliminarCalle(Calle calle);
    boolean existeCalle(Calle calle);
    boolean existeInterseccion(Interseccion interseccion);
    int buscarMenorTiempo(double[] tiempo, boolean[] visitado);
    void dijkstraTiempo(Interseccion origen, Interseccion destino);
    void reportarAccidente(Calle calle, String gravedad);
    void resolverAccidente(Calle calle);
    void mostrarCamino(int[] anterior, int destino);
    void mostrarMatriz();

}
