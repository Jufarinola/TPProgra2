package FlujoVehicular;

public class Vehiculo {
    public String patente;
    public int velocidadActual;

    public Vehiculo(String patente) {
        this.patente = patente;
        this.velocidadActual = 0;
    }

    public Vehiculo(String patente, int velocidadActual) {
        this.patente = patente;
        this.velocidadActual = velocidadActual;
    }
}
