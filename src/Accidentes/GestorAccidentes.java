package Accidentes;

import Interfaces.IGestorAccidentes;

public class GestorAccidentes implements IGestorAccidentes {
    private Accidente[][] matrizAccidentes;
    private int cantidad;

    public GestorAccidentes(int cantidad) {
        this.cantidad = cantidad;
        this.matrizAccidentes = new Accidente[cantidad][cantidad];
    }

    public double obtenerDemoraporAccidente(int posOrigen, int posDestino){
        Accidente accidente = matrizAccidentes[posOrigen][posDestino];
        if (accidente != null) {
            if (accidente.gravedad.equalsIgnoreCase("Leve")) return 15.0;
            if (accidente.gravedad.equalsIgnoreCase("Moderada")) return 45.0;
            if (accidente.gravedad.equalsIgnoreCase("Grave")) return 999999.0;
        }
        return 0.0;
    }

    public void reportarAccidente(int posOrigen, int posDestino, String gravedad){
        matrizAccidentes[posOrigen][posDestino] = new Accidente(gravedad);
        matrizAccidentes[posOrigen][posDestino].mostrarAccidente();
    }

    public void resolverAccidente(int posOrigen, int posDestino) {
        matrizAccidentes[posOrigen][posDestino] = null;
        System.out.println("Accidente resuelto. Trafico normalizado");
    }
}