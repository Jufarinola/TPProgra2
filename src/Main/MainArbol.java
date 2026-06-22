package Main;

import ArbolCiudad.Arbol;
import ArbolCiudad.Manzana;
import ArbolCiudad.NodoArbol;

public class MainArbol {
    static void main() {
        Arbol arbol = new Arbol();

        //Crear raiz y zonas
        NodoArbol BuenosAires = new NodoArbol("Buenos Aires");
        NodoArbol ZonaNorte = new NodoArbol("Zona Norte");
        NodoArbol ZonaSur = new NodoArbol("Zona Sur");
        NodoArbol ZonaOeste = new NodoArbol("Zona Oeste");
        NodoArbol CapitalFederal = new NodoArbol("Capital Federal");

        arbol.agregarRaiz(BuenosAires);
        arbol.agregarHijo(BuenosAires, ZonaNorte);
        arbol.agregarHijo(BuenosAires, ZonaOeste);
        arbol.agregarHijo(BuenosAires, ZonaSur);
        arbol.agregarHijo(BuenosAires, CapitalFederal);

        //Crear barrio
        NodoArbol Boedo = new NodoArbol("Boedo");
        arbol.agregarHijo(CapitalFederal, Boedo);

        //Crear manzanas
        Manzana m1 = new Manzana(
                "Manzana 1",
                MainGrafos.A,
                MainGrafos.B,
                MainGrafos.D,
                MainGrafos.E
        );

        Manzana m2 = new Manzana(
                "Manzana 2",
                MainGrafos.B,
                MainGrafos.C,
                MainGrafos.E,
                MainGrafos.F
        );

        Manzana m3 = new Manzana(
                "Manzana 3",
                MainGrafos.D,
                MainGrafos.E,
                MainGrafos.G,
                MainGrafos.H
        );

        Manzana m4 = new Manzana(
                "Manzana 4",
                MainGrafos.E,
                MainGrafos.F,
                MainGrafos.H,
                MainGrafos.I
        );


        NodoArbol nodoM1 = new NodoArbol(m1);
        NodoArbol nodoM2 = new NodoArbol(m2);

        NodoArbol nodoM3 = new NodoArbol(m3);
        NodoArbol nodoM4 = new NodoArbol(m4);

        //Agregar manzana a barrio
        arbol.agregarHijo(Boedo,nodoM1);
        arbol.agregarHijo(Boedo,nodoM2);
        arbol.agregarHijo(Boedo,nodoM3);
        arbol.agregarHijo(Boedo,nodoM4);


        //Mostrar arbol
        arbol.mostrarArbol();
        System.out.println();

        //Mostrar manzana
        m1.mostrarManzana();
        System.out.println();

        //Buscar barrio dentro del arbol
        arbol.buscarBarrio("boedo");


        //Mostrar barrios de zonas
        arbol.mostrarBarriosDeZona("Capital Federal");
        System.out.println();

        //Eliminar un barrio
        arbol.eliminarBarrio("Boedo","Capital Federal");
        System.out.println();
        arbol.mostrarArbol();

    }
}