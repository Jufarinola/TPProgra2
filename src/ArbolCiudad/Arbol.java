package ArbolCiudad;


import Interfaces.IArbol;

import java.security.PublicKey;

public class Arbol implements IArbol {
    private NodoArbol raiz;
    private int cant;  //HOLA!!

    public Arbol(){
        raiz=null;
        cant=0;
    }

    @Override
    public void agregarRaiz(NodoArbol nuevo){
        if(raiz == null){
            raiz = nuevo;
            cant++;
        } else {
            System.out.println("El arbol ya tiene raiz");
        }
    }

    @Override
    public void agregarHijo(NodoArbol padre, NodoArbol nuevo){
        if(padre == null){
            System.out.println("El padre no existe");
            return;
        }

        if(padre.primerHijo == null){
            padre.primerHijo = nuevo;
        } else {
            NodoArbol aux = padre.primerHijo;

            while(aux.siguienteHermano != null){
                aux = aux.siguienteHermano;
            }

            aux.siguienteHermano = nuevo;
        }

        cant++;
    }

    @Override
    public NodoArbol buscarZona(String nombre){
        if(raiz == null){
            return null;
        }

        NodoArbol aux = raiz.primerHijo;

        while(aux != null){
            if(aux.nombre.equals(nombre)){
                return aux;
            }

            aux = aux.siguienteHermano;
        }

        return null;
    }

    @Override
    public boolean existeZona(String nombre){
        return buscarZona(nombre) != null;
    }

    @Override
    public boolean buscarBarrio(String nombre){
        if(raiz == null){
            return false;
        }

        NodoArbol zona = raiz.primerHijo;

        while(zona != null){
            NodoArbol barrio = zona.primerHijo;

            while(barrio != null){
                if(barrio.nombre.equals(nombre)){
                    System.out.println("Barrio encontrado - Pertenece a " + zona.nombre);
                    return true;
                }

                barrio = barrio.siguienteHermano;
            }

            zona = zona.siguienteHermano;
        }

        return false;
    }

    @Override
    public void mostrarBarriosDeZona(String nombre){
        NodoArbol zona = buscarZona(nombre);

        if(zona == null){
            System.out.println("La zona ingresada no existe");
            return;
        }

        NodoArbol barrio = zona.primerHijo;

        if(barrio == null){
            System.out.println("La zona no tiene barrios cargados");
            return;
        }

        while(barrio != null){
            System.out.println(barrio.nombre);
            barrio = barrio.siguienteHermano;
        }
    }

    @Override
    public void eliminarBarrio(String nombreBarrio, String nombreZona){
        NodoArbol zona = buscarZona(nombreZona);

        if(zona == null){
            System.out.println("La zona ingresada no existe");
            return;
        }

        NodoArbol actual = zona.primerHijo;
        NodoArbol anterior = null;

        while(actual != null){
            if(actual.nombre.equals(nombreBarrio)){

                if(anterior == null){
                    zona.primerHijo = actual.siguienteHermano;
                } else {
                    anterior.siguienteHermano = actual.siguienteHermano;
                }

                cant--;
                System.out.println("Barrio eliminado");
                return;
            }

            anterior = actual;
            actual = actual.siguienteHermano;
        }

        System.out.println("El barrio ingresado no existe en esa zona");
    }

    @Override
    public void mostrarArbol() {

        if (raiz == null) {
            return;
        }

        System.out.println(raiz.nombre);

        NodoArbol hijo = raiz.primerHijo;

        while (hijo != null) {

            mostrarRecursivo(hijo, "", hijo.siguienteHermano == null);

            hijo = hijo.siguienteHermano;
        }
    }

    private void mostrarRecursivo(NodoArbol nodo, String prefijo, boolean ultimo) {

        System.out.print(prefijo);

        if (ultimo) {
            System.out.print("└── ");
        } else {
            System.out.print("├── ");
        }

        System.out.println(nodo.nombre);

        NodoArbol hijo = nodo.primerHijo;

        while (hijo != null) {

            mostrarRecursivo(
                    hijo,
                    prefijo + (ultimo ? "    " : "│   "),
                    hijo.siguienteHermano == null
            );

            hijo = hijo.siguienteHermano;
        }
    }
}
