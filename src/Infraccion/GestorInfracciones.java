package Infraccion;
import reportes.RegistroEventos;

public class GestorInfracciones {
    private NodoInfraccion primero;

    public GestorInfracciones() {
        this.primero = null;
    }

    public void registrarInfraccion(Infraccion infraccion) {
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

        RegistroEventos.registrar(
                "INFRACCIÓN",
                "Se registró una infracción de " + infraccion.motivo + " en " + infraccion.calle,
                infraccion
        );

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
            System.out.println("\nINFRACCIÓN " + contador);
            aux.dato.mostrarInfraccion();

            aux = aux.siguiente;
            contador++;
        }
    }
}
