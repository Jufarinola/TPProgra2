package reportes;

public class NodoPila {
    public Object dato;
    public NodoPila siguiente;

    public NodoPila(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
