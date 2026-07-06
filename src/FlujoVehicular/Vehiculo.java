package FlujoVehicular;

public class Vehiculo {
    public String patente;
    public int velocidadActual;
    public int prioridad;

    public Vehiculo(String patente, int velocidadActual, int prioridad) {
        this.patente = patente;
        this.velocidadActual = velocidadActual;
        this.prioridad = prioridad;
    }
}
