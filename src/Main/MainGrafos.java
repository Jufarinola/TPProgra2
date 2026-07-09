package Main;

import GrafoVial.GrafoVial;
import GrafoVial.Interseccion;
import GrafoVial.Calle;
import Dispositivos.Camara;
import FlujoVehicular.Vehiculo;
import Infraccion.GestorInfracciones;
import Dispositivos.Semaforo;
import reportes.RegistroEventos;
import ArbolCiudad.Arbol;
import ArbolCiudad.Manzana;
import ArbolCiudad.NodoArbol;
import reportes.EventosSistema;

import javax.swing.plaf.synth.SynthOptionPaneUI;


public class MainGrafos {

    public static Interseccion A =
            new Interseccion("A");

    public static Interseccion B =
            new Interseccion("B");

    public static Interseccion C =
            new Interseccion("C");

    public static Interseccion D =
            new Interseccion("D");

    public static Interseccion E =
            new Interseccion("E");

    public static Interseccion F =
            new Interseccion("F");

    public static Interseccion G =
            new Interseccion("G");

    public static Interseccion H =
            new Interseccion("H");

    public static Interseccion I =
            new Interseccion("I");

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        GrafoVial grafo = new GrafoVial(10, arbol);

        NodoArbol ciudad = new NodoArbol("Buenos Aires");
        arbol.agregarRaiz(ciudad);

        NodoArbol zonaCentro = new NodoArbol("Zona Centro");
        arbol.agregarHijo(ciudad, zonaCentro);

        NodoArbol barrioBoedo = new NodoArbol("Boedo");
        arbol.agregarHijo(zonaCentro, barrioBoedo);

        Manzana m1 = new Manzana("Manzana 1", A, B, D, E);
        Manzana m2 = new Manzana("Manzana 2", B, C, E, F);
        Manzana m3 = new Manzana("Manzana 3", D, E, G, H);
        Manzana m4 = new Manzana("Manzana 4", E, F, H, I);

        arbol.agregarHijo(barrioBoedo, new NodoArbol(m1));
        arbol.agregarHijo(barrioBoedo, new NodoArbol(m2));
        arbol.agregarHijo(barrioBoedo, new NodoArbol(m3));
        arbol.agregarHijo(barrioBoedo, new NodoArbol(m4));


        grafo.agregarInterseccion(A);
        grafo.agregarInterseccion(B);
        grafo.agregarInterseccion(C);
        grafo.agregarInterseccion(D);
        grafo.agregarInterseccion(E);
        grafo.agregarInterseccion(F);
        grafo.agregarInterseccion(G);
        grafo.agregarInterseccion(H);
        grafo.agregarInterseccion(I);

        Calle c1 = new Calle("Av. Independencia", 3500, A, B, 1200, 60);
        Calle c2 = new Calle("Av. Independencia", 3600, B, C, 1400, 60);
        Calle c3 = new Calle("Av. la plata", 900, A, D, 1800, 80);
        Calle c4 = new Calle("Estados Unidos", 1000, D, E, 1000, 30);
        Calle c5 = new Calle("Muñis", 1000, E, B, 1005, 30);
        Calle c6 = new Calle("Estados Unidos", 1200, E, F, 1230, 30);
        Calle c7 = new Calle("Jose marmol", 1330, C, F, 1120, 40);
        Calle c8 = new Calle("Av. la plata", 2000, D,G,2000,80);
        Calle c9 = new Calle("Carlos calvo", 1000, H, G, 5000, 35);
        Calle c10 = new Calle("Muñis", 1000, H, E, 1000, 30);
        Calle c11 = new Calle("Carlos calvo", 4000, I, H, 1200, 35);
        Calle c12 = new Calle("Jose marmol", 3000, F, I, 1000, 40);


        grafo.insertarCalle(c1);
        grafo.insertarCalle(c2);
        grafo.insertarCalle(c3);
        grafo.insertarCalle(c4);
        grafo.insertarCalle(c5);
        grafo.insertarCalle(c6);
        grafo.insertarCalle(c7);
        grafo.insertarCalle(c8);
        grafo.insertarCalle(c9);
        grafo.insertarCalle(c10);
        grafo.insertarCalle(c11);
        grafo.insertarCalle(c12);

        System.out.println("==================================");
        System.out.println("INICIO DEL VIAJE");
        System.out.println("==================================");

        grafo.iniciarViaje(A, H);

        // ===============================
        // OCURRE UN ACCIDENTE
        // ===============================

        System.out.println("\n==================================");
        System.out.println("ACCIDENTE EN LA RUTA");
        System.out.println("==================================");

        grafo.reportarAccidente(c7, "Grave");

        System.out.println("\nEl sistema contacta con emergencias.");

        System.out.println();
        grafo.resolverAccidente(c7,I);



        System.out.println("\n======================================================");
        System.out.println("--- SIMULACIÓN DE FLUJO VEHICULAR Y INFRACCIONES ---");
        System.out.println("======================================================");

        GestorInfracciones gestorInfracciones = new GestorInfracciones();

        Semaforo semaforoA = new Semaforo("S001", A);
        Camara camaraA = new Camara("CAM001", A);

        semaforoA.activar();
        camaraA.activar();

        Vehiculo auto1 = new Vehiculo("AUTO-1",90,2);
        Vehiculo auto2 = new Vehiculo("AUTO-2",60,2);
        Vehiculo auto3 = new Vehiculo("AUTO-3",54,2);
        Vehiculo auto4 = new Vehiculo("AUTO-4",43,2);
        Vehiculo auto5 = new Vehiculo("AUTO-5",55,2);

        System.out.println("\n--- LLEGADA DE VEHÍCULOS A LA INTERSECCIÓN A ---");
        A.llegarVehiculo(auto1);
        A.llegarVehiculo(auto2);
        A.llegarVehiculo(auto3);
        A.llegarVehiculo(auto4);
        A.llegarVehiculo(auto5);

        System.out.println();

        semaforoA.cambiarAVerde();

        semaforoA.liberarTrafico(c1, camaraA, gestorInfracciones);
        semaforoA.liberarTrafico(c1, camaraA, gestorInfracciones);
        semaforoA.liberarTrafico(c1, camaraA, gestorInfracciones);

        System.out.println("\n--- VEHÍCULOS EN CALLE ---");
        c1.mostrarVehiculosEnCalle();

        System.out.println("\n--- INFRACCIONES REGISTRADAS ---");
        gestorInfracciones.mostrarInfracciones();

        System.out.println("\n================");
        System.out.println("--- Reportes ---");
        System.out.println("=================");

        System.out.println();

        RegistroEventos.mostrarEventos();

        System.out.println();
        arbol.mostrarEventosDeManzana("Manzana 1");
        System.out.println();
        arbol.mostrarCriticidad();
        System.out.println();



    }
}