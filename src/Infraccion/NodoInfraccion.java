package Infraccion;

public class NodoInfraccion {
    Infraccion dato;
    NodoInfraccion siguiente;

    public NodoInfraccion(Infraccion dato){
        this.dato = dato;
        this.siguiente = null;
    }
}
