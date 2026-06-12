package GrafoVial;

import javax.print.DocFlavor;

public class GrafoVial {
    Interseccion[] intersecciones;
    Calle[][] matriz;
    int cantidad;
    int capacidad;

    public GrafoVial(int capacidad){
        this.capacidad = capacidad;
        this.intersecciones = new Interseccion[capacidad];
        this.matriz = new Calle[capacidad][capacidad];
        this.cantidad = 0;
    }

    public void agregarInterseccion(Interseccion interseccion){
        if(cantidad == capacidad){
            System.out.println("No se pueden insertar mas intersecciones");
            return;
        }

        if(existeInterseccion(interseccion)){
            System.out.println("La interseccion ingresada ya existe");
            return;
        }

        intersecciones[cantidad] = interseccion;
        cantidad++;
    }

    public int obtenerIndice(Interseccion interseccion){
        for(int i = 0; i < cantidad; i++){
            if(intersecciones[i].equals(interseccion)){
                return i;
            }
        }
        return -1;
    }

    public void insertarCalle(Calle calle){
        int posOrigen = obtenerIndice(calle.origen);
        int posDestino = obtenerIndice(calle.destino);

        if(posOrigen == -1 || posDestino == -1){
            System.out.println("Una de las intersecciones no existe");
            return;
        }

        matriz[posOrigen][posDestino] = calle;
    }

    public void eliminarInterseccion(Interseccion interseccion){
        int pos = obtenerIndice(interseccion);

        if(pos == -1){
            System.out.println("No existe la interseccion ingresada");
            return;
        }

        for(int i = pos; i < cantidad - 1; i++){
            intersecciones[i] = intersecciones[i + 1];
        }

        for(int i = pos; i < cantidad - 1; i++){
            for(int j = 0; j < cantidad; j++){
                matriz[i][j] = matriz[i + 1][j];
            }
        }

        for(int j = pos; j < cantidad - 1; j++){
            for(int i = 0; i < cantidad; i++){
                matriz[i][j] = matriz[i][j + 1];
            }
        }

        cantidad--;

        intersecciones[cantidad] = null;

        for(int i = 0; i < capacidad; i++){
            matriz[cantidad][i] = null;
            matriz[i][cantidad] = null;
        }
    }

    public void eliminarCalle(Calle calle){
        int posOrigen = obtenerIndice(calle.origen);
        int posDestino = obtenerIndice(calle.destino);

        if(posOrigen == -1 || posDestino == -1){
            System.out.println("Una de las intersecciones no existe");
            return;
        }

        if(!existeCalle(calle)){
            System.out.println("La calle no existe");
            return;
        }

        matriz[posOrigen][posDestino] = null;
    }

    public boolean existeCalle(Calle calle){
        int posOrigen = obtenerIndice(calle.origen);
        int posDestino = obtenerIndice(calle.destino);

        if(posOrigen == -1 || posDestino == -1){
            return false;
        }

        return matriz[posOrigen][posDestino] != null;
    }

    public boolean existeInterseccion(Interseccion interseccion){
        return obtenerIndice(interseccion) != -1;
    }

    public double calcularTiempo(Calle calle){
        double distanciaKm = calle.distancia / 1000.0;

        double tiempoHoras = distanciaKm / calle.limiteVelocidad;

        double tiempoMinutos = tiempoHoras * 60;

        return tiempoMinutos;
    }

    public int buscarMenorTiempo(double[] tiempo, boolean[] visitado){
        double menor = 999999;
        int posMenor = -1;

        for(int i = 0; i < cantidad; i++){
            if(!visitado[i] && tiempo[i] < menor){
                menor = tiempo[i];
                posMenor = i;
            }
        }

        return posMenor;
    }


    public void dijkstraTiempo(Interseccion origen, Interseccion destino){

        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if(posOrigen == -1 || posDestino == -1){
            System.out.println("Origen o destino no existen");
            return;
        }

        double[] tiempo = new double[cantidad];
        boolean[] visitado = new boolean[cantidad];
        int[] anterior = new int[cantidad];

        for(int i = 0; i < cantidad; i++){
            tiempo[i] = 999999;
            visitado[i] = false;
            anterior[i] = -1;
        }

        tiempo[posOrigen] = 0;

        for(int i = 0; i < cantidad; i++){

            int actual = buscarMenorTiempo(tiempo, visitado);

            if(actual == -1){
                break;
            }

            visitado[actual] = true;

            for(int vecino = 0; vecino < cantidad; vecino++){

                if(matriz[actual][vecino] != null && !visitado[vecino]){

                    Calle calle = matriz[actual][vecino];

                    double nuevoTiempo = tiempo[actual] + calcularTiempo(calle);

                    if(nuevoTiempo < tiempo[vecino]){
                        tiempo[vecino] = nuevoTiempo;
                        anterior[vecino] = actual;
                    }
                }
            }
        }

        if(tiempo[posDestino] == 999999){
            System.out.println("No existe camino entre origen y destino");
            return;
        }

        System.out.println("Tiempo minimo: " + tiempo[posDestino]);
        System.out.print("Camino: ");
        mostrarCamino(anterior, posDestino);
        System.out.println();
    }

    public void mostrarCamino(int[] anterior, int destino){
        int[] camino = new int[cantidad];
        int cantCamino = 0;
        int actual = destino;

        while(actual != -1){
            camino[cantCamino] = actual;
            cantCamino++;
            actual = anterior[actual];
        }

        for(int i = cantCamino - 1; i >= 0; i--){
            System.out.print(intersecciones[camino[i]].nombre);

            if(i != 0){
                System.out.print(" -> ");
            }
        }
    }

    public void mostrarMatriz(){
        System.out.println("MATRIZ DE ADYACENCIA");

        for(int i = 0; i < cantidad; i++){
            for(int j = 0; j < cantidad; j++){
                if(matriz[i][j] != null){
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
