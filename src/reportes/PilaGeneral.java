package reportes;

public class PilaGeneral {
    private NodoPila tope;

    public PilaGeneral() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void apilar(Object dato) {
        NodoPila nuevo = new NodoPila(dato);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Object desapilar() {
        if (estaVacia()) {
            return null;
        }

        Object dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }

    public void mostrarPila() {
        NodoPila aux = tope;

        while (aux != null) {
            if (aux.dato instanceof EventosSistema) {
                EventosSistema evento = (EventosSistema) aux.dato;
                evento.mostrarEvento();
            } else {
                System.out.println(aux.dato);
            }

            aux = aux.siguiente;
        }
    }
}
