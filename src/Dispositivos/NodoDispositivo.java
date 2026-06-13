package Dispositivos;

public class NodoDispositivo {

    public Dispositivo dato;
    public NodoDispositivo siguiente;

    public NodoDispositivo(Dispositivo dato) {

        this.dato = dato;
        this.siguiente = null;
    }
}