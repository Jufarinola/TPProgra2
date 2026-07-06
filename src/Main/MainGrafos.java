package Main;

import GrafoVial.GrafoVial;
import GrafoVial.Interseccion;
import GrafoVial.Calle;

public class MainGrafos {

    public static Interseccion A =
            new Interseccion("Av la plata y Av independencia");

    public static Interseccion B =
            new Interseccion("Muñis y Av independencia");

    public static Interseccion C =
            new Interseccion("Jose marmol y Av independencia");

    public static Interseccion D =
            new Interseccion("Av la plata y Estados Unidos");

    public static Interseccion E =
            new Interseccion("Muñis y Estados Unidos");

    public static Interseccion F =
            new Interseccion("Jose Marmol y Estados Unidos");

    public static Interseccion G =
            new Interseccion("Av la plata y Carlos Calvo");

    public static Interseccion H =
            new Interseccion("Muñis y Carlos Calvo");

    public static Interseccion I =
            new Interseccion("Jose Marmol y Carlos Calvo");

    public static void main(String[] args) {
        GrafoVial grafo = new GrafoVial(10);

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

        System.out.println("\nEl sistema recalculó automáticamente la mejor ruta.");


        System.out.println("\n==================================");
        System.out.println("--- SIMULACIÓN DE FLUJO VEHICULAR ---");
        System.out.println("==================================");

        Dispositivos.Semaforo semaforoA = new Dispositivos.Semaforo("SEM-A", A);

        System.out.println("\n--- LLEGADA DE VEHÍCULOS A LA INTERSECCIÓN A ---");
        A.llegarVehiculo(new FlujoVehicular.Vehiculo("AUTO-1"));
        A.llegarVehiculo(new FlujoVehicular.Vehiculo("AUTO-2"));
        A.llegarVehiculo(new FlujoVehicular.Vehiculo("AUTO-3"));
        A.llegarVehiculo(new FlujoVehicular.Vehiculo("AUTO-4"));
        A.llegarVehiculo(new FlujoVehicular.Vehiculo("AUTO-5"));

        semaforoA.cicloAutomatico(2);


    }
}
