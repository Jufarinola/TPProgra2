package ArbolCiudad;


import Interfaces.IArbol;

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
            nuevo.padre = padre;
        } else {
            NodoArbol aux = padre.primerHijo;

            while(aux.siguienteHermano != null){
                aux = aux.siguienteHermano;
            }

            aux.siguienteHermano = nuevo;
            nuevo.padre = padre;
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


    public NodoArbol buscarManzana(String nombre) {
        if (raiz == null) {
            return null;
        }

        NodoArbol zona = raiz.primerHijo;

        while (zona != null) {
            NodoArbol barrio = zona.primerHijo;

            while (barrio != null) {
                NodoArbol manzana = barrio.primerHijo;

                while (manzana != null) {
                    if (manzana.nombre.equals(nombre)) {
                        return manzana;
                    }
                    manzana = manzana.siguienteHermano;
                }
                barrio = barrio.siguienteHermano;
            }
            zona = zona.siguienteHermano;
        }
        return null;
    }


    public void registrarAccidente(String nombreManzana) {
        NodoArbol nodo = buscarManzana(nombreManzana);

        if (nodo == null) {
            System.out.println("No se encontró el nodo: " + nombreManzana);
            return;
        }

        nodo.cantidadAccidentes++;
        actualizarCriticidadDesdeManzanas();

        System.out.println("Accidente registrado en " + nodo.nombre);
    }

    public void registrarInfraccion(String nombreManzana) {
        NodoArbol nodo = buscarManzana(nombreManzana);

        if (nodo == null) {
            System.out.println("No se encontró el nodo: " + nombreManzana);
            return;
        }

        nodo.cantidadInfracciones++;
        actualizarCriticidadDesdeManzanas();

        System.out.println("Infracción registrada en " + nodo.nombre);
    }

    public void registrarVehiculos(String nombreManzana, int cantidad) {
        NodoArbol nodo = buscarManzana(nombreManzana);

        if (nodo == null) {
            System.out.println("No se encontró el nodo: " + nombreManzana);
            return;
        }

        nodo.cantidadVehiculos += cantidad;
        actualizarCriticidadDesdeManzanas();

        System.out.println("Vehículos registrados en " + nodo.nombre);
    }

    public void mostrarCriticidad(String nombreManzana) {
        if (raiz == null) {
            System.out.println("El árbol está vacío");
            return;
        }

        mostrarCriticidad();
    }

    public void mostrarCriticidad() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
            return;
        }

        actualizarCriticidadDesdeManzanas();

        NodoArbol zona = raiz.primerHijo;

        while (zona != null) {
            mostrarDatosCriticidad("Zona", zona);

            NodoArbol barrio = zona.primerHijo;

            while (barrio != null) {
                mostrarDatosCriticidad("Barrio", barrio);
                barrio = barrio.siguienteHermano;
            }

            zona = zona.siguienteHermano;
        }
    }

    private void mostrarDatosCriticidad(String tipo, NodoArbol nodo) {
        System.out.println(tipo + ": " + nodo.nombre);
        System.out.println("Accidentes: " + nodo.cantidadAccidentes);
        System.out.println("Infracciones: " + nodo.cantidadInfracciones);
        System.out.println("Vehiculos: " + nodo.cantidadVehiculos);
        System.out.println("Puntaje: " + nodo.puntajeCriticidad);
        System.out.println("-------------------------");
    }

    private void actualizarCriticidadDesdeManzanas() {
        if (raiz == null) {
            return;
        }

        actualizarCriticidadRecursivo(raiz);
    }

    private void actualizarCriticidadRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        NodoArbol hijo = nodo.primerHijo;

        if (hijo != null) {
            nodo.cantidadAccidentes = 0;
            nodo.cantidadInfracciones = 0;
            nodo.cantidadVehiculos = 0;

            while (hijo != null) {
                actualizarCriticidadRecursivo(hijo);

                nodo.cantidadAccidentes += hijo.cantidadAccidentes;
                nodo.cantidadInfracciones += hijo.cantidadInfracciones;
                nodo.cantidadVehiculos += hijo.cantidadVehiculos;

                hijo = hijo.siguienteHermano;
            }
        }

        nodo.calcularPuntajeCriticidad();
    }

    private void mostrarCriticidadRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        System.out.println("Nodo: " + nodo.nombre);
        System.out.println("Accidentes: " + nodo.cantidadAccidentes);
        System.out.println("Infracciones: " + nodo.cantidadInfracciones);
        System.out.println("Vehículos: " + nodo.cantidadVehiculos);
        System.out.println("Puntaje: " + nodo.puntajeCriticidad);
        System.out.println("-------------------------");

        mostrarCriticidadRecursivo(nodo.primerHijo);
        mostrarCriticidadRecursivo(nodo.siguienteHermano);
    }

    public NodoArbol buscarNodoMasCritico() {
        if (raiz == null) {
            return null;
        }

        actualizarCriticidadDesdeManzanas();

        NodoArbol masCritico = null;
        NodoArbol zona = raiz.primerHijo;

        while (zona != null) {
            NodoArbol barrio = zona.primerHijo;

            while (barrio != null) {
                if (masCritico == null || barrio.puntajeCriticidad > masCritico.puntajeCriticidad) {
                    masCritico = barrio;
                }

                barrio = barrio.siguienteHermano;
            }

            zona = zona.siguienteHermano;
        }

        return masCritico;
    }

    public void mostrarNodoMasCritico() {
        NodoArbol masCritico = buscarNodoMasCritico();

        if (masCritico == null) {
            System.out.println("No hay nodos cargados");
            return;
        }

        System.out.println("Nodo más crítico: " + masCritico.nombre);
        System.out.println("Accidentes: " + masCritico.cantidadAccidentes);
        System.out.println("Infracciones: " + masCritico.cantidadInfracciones);
        System.out.println("Vehículos: " + masCritico.cantidadVehiculos);
        System.out.println("Puntaje: " + masCritico.puntajeCriticidad);
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
