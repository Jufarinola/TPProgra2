package Dispositivos;


import Interfaces.IDiccionario;
import Interfaces.IDispositivo;

public class Diccionario implements IDiccionario {

    public NodoDispositivo primero;

    public Diccionario() {
        primero = null;
    }


    public void agregar(Dispositivo dispositivo) {

        NodoDispositivo nuevo =
                new NodoDispositivo(dispositivo);

        if (primero == null) {
            primero = nuevo;
        }
        else {

            NodoDispositivo aux = primero;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
        }
    }

    public Dispositivo buscar(String codigo) {

        NodoDispositivo aux = primero;

        while (aux != null) {

            if (aux.dato.codigo.equals(codigo)) {
                return aux.dato;
            }

            aux = aux.siguiente;
        }

        return null;
    }


    public void mostrar() {

        NodoDispositivo aux = primero;

        while (aux != null) {

            System.out.println(
                    aux.dato.codigo +
                            " | " +
                            aux.dato.ubicacion.nombre +
                            " | Estado: " +
                            aux.dato.estado
            );

            aux = aux.siguiente;
        }
    }
}