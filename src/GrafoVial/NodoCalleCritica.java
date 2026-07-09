package GrafoVial;

public class NodoCalleCritica {
    public CalleCritica dato;
    public NodoCalleCritica siguiente;

    public NodoCalleCritica(CalleCritica dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
