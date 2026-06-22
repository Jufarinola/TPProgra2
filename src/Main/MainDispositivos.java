package Main;

import Dispositivos.Camara;
import Dispositivos.Diccionario;
import Dispositivos.Dispositivo;
import Dispositivos.Semaforo;

import GrafoVial.Interseccion;

public class MainDispositivos {
    public static void main(String[] args) {



        // Crear dispositivos
        Semaforo s1 = new Semaforo("S001", MainGrafos.A);
        Camara c1 = new Camara("C001", MainGrafos.B);

        // Activar dispositivos
        s1.activar();
        s1.cambiarAVerde();

        c1.activar();

        // Crear diccionario
        Diccionario dispositivos = new Diccionario();

        dispositivos.agregar(s1);
        dispositivos.agregar(c1);

        // Mostrar todos
        System.out.println("LISTA DE DISPOSITIVOS");
        dispositivos.mostrar();

        // Buscar uno por código
        Dispositivo encontrado = dispositivos.buscar("C001");

        if (encontrado != null) {
            System.out.println("\nDispositivo encontrado:");
            System.out.println("Codigo: " + encontrado.codigo);
            System.out.println("Ubicacion: " + encontrado.ubicacion.nombre);
            System.out.println("Estado: " + encontrado.estado);
        }

        // Consultar estado
        System.out.println("\nEstado del semaforo: " +
                s1.consultarEstado());

        System.out.println("Color del semaforo: " +
                s1.color);
    }
}
