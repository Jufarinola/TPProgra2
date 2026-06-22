package ArbolCiudad;

import Interfaces.INodoArbol;

public class NodoArbol implements INodoArbol {
    String nombre;

    Manzana manzana;

    NodoArbol primerHijo;
    NodoArbol siguienteHermano;

    public NodoArbol(String nombre){
        this.nombre = nombre;
        this.manzana = null;
        this.primerHijo = null;
        this.siguienteHermano = null;
    }

    public NodoArbol(Manzana manzana){
        this.nombre = manzana.nombre;
        this.manzana = manzana;
        this.primerHijo = null;
        this.siguienteHermano = null;
    }

    @Override
    public void mostrarNodo(){
        System.out.println(nombre);
    }
}
