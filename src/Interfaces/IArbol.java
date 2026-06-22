package Interfaces;

import ArbolCiudad.NodoArbol;

public interface IArbol {
    void agregarRaiz(NodoArbol nuevo);
    void agregarHijo(NodoArbol padre, NodoArbol nuevo);
    NodoArbol buscarZona(String nombre);
    boolean existeZona(String nombre);
    boolean buscarBarrio(String nombre);
    void mostrarBarriosDeZona(String nombre);
    void eliminarBarrio(String nombreBarrio, String nombreZona);
    void mostrarArbol();
}
