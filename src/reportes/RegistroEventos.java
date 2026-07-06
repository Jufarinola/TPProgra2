package reportes;

public class RegistroEventos {
    public static PilaGeneral pila = new PilaGeneral();

    public static void registrar(String tipo, String descripcion, Object objeto) {
        EventosSistema evento = new EventosSistema(tipo, descripcion, objeto);
        pila.apilar(evento);
    }

    public static void mostrarEventos() {
        pila.mostrarPila();
    }
}
