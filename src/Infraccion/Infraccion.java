package Infraccion;

import java.time.LocalDateTime;

public class Infraccion {
    public String patente;
    public String motivo;
    public String calle;
    public LocalDateTime fechaHora;
    public double monto;

    public Infraccion(String patente, String motivo, String calle, double monto) {
        this.patente = patente;
        this.motivo = motivo;
        this.calle = calle;
        this.monto = monto;
        this.fechaHora = LocalDateTime.now();
    }

    public void mostrarInfraccion() {
        System.out.println("Patente: " + patente);
        System.out.println("Motivo: " + motivo);
        System.out.println("Calle: " + calle);
        System.out.println("Monto: $" + monto);
        System.out.println("Fecha: " + fechaHora);
    }

}
