package ArbolCiudad;

public class MainArbol {
    static void main() {
        Arbol arbol = new Arbol();

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

        NodoArbol palermo = new NodoArbol("Palermo");
        NodoArbol Avellaneda = new NodoArbol("Avellaneda");
        arbol.agregarHijo(CapitalFederal, palermo);
        arbol.agregarHijo(ZonaSur,Avellaneda);

        arbol.mostrarArbol();


        boolean b = arbol.buscarBarrio("Avellaneda");
        System.out.println(b);
        arbol.mostrarBarriosDeZona("Capital Federal");
        arbol.eliminarBarrio("Palermo","Capital Federal");
        arbol.mostrarArbol();

    }
}
