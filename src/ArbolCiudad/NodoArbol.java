package ArbolCiudad;

public class NodoArbol {
    String nombre;
    NodoArbol primerHijo;
    NodoArbol siguienteHermano;

    public NodoArbol(String nombre){
        this.nombre= nombre;
        this.primerHijo = null;
        this.siguienteHermano = null;
    }
}
