package GrafoVial;

public class Calle {
    String nombre;
    int altura;

    Interseccion origen;
    Interseccion destino;

    int distancia;
    int limiteVelocidad;

    public Calle(String nombre, int altura,
                 Interseccion origen, Interseccion destino,
                 int distancia, int limiteVelocidad) {

        this.nombre = nombre;
        this.altura = altura;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.limiteVelocidad = limiteVelocidad;
    }
}
