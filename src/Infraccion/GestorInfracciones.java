package Infraccion;
import ArbolCiudad.Arbol;
import Dispositivos.Camara;
import reportes.EventosSistema;
import reportes.RegistroEventos;
import GrafoVial.Calle;

public class GestorInfracciones {
    private NodoInfraccion primero;

    public GestorInfracciones() {
        this.primero = null;
    }

    public void registrarInfraccion(Infraccion infraccion, Calle calle) {
        NodoInfraccion nuevo = new NodoInfraccion(infraccion);

        if (primero == null) {
            primero = nuevo;
        } else {
            NodoInfraccion aux = primero;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
        }

        EventosSistema evento = RegistroEventos.registrar(
                "INFRACCION",
                "Se registró una infracción de " + infraccion.motivo + " en " + infraccion.calle,
                infraccion
        );

        Arbol.registrarEventoPorCalle(calle, evento);

        System.out.println("Infracción registrada correctamente.");
    }

    public void mostrarInfracciones() {
        if (primero == null) {
            System.out.println("No hay infracciones registradas.");
            return;
        }

        NodoInfraccion aux = primero;
        int contador = 1;

        while (aux != null) {
            System.out.println("\nINFRACCION " + contador);
            aux.dato.mostrarInfraccion();

            aux = aux.siguiente;
            contador++;
        }
    }
}
