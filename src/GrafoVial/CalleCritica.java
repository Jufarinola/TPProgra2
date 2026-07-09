package GrafoVial;

public class CalleCritica {
    public Calle calle;
    public double demoraAccidente;
    public int cantidadVehiculos;
    public double puntajeCriticidad;

    public CalleCritica(Calle calle, double demoraAccidente, int cantidadVehiculos) {
        this.calle = calle;
        this.demoraAccidente = demoraAccidente;
        this.cantidadVehiculos = cantidadVehiculos;
        this.puntajeCriticidad = calcularPuntaje();
    }

    private double calcularPuntaje() {
        double puntaje = 0;

        if (demoraAccidente >= 999999) {
            puntaje += 1000;
        } else {
            puntaje += demoraAccidente;
        }

        puntaje += cantidadVehiculos * 10;

        if (calle.limiteVelocidad >= 60) {
            puntaje += 15;
        }

        return puntaje;
    }

    public void mostrar() {
        System.out.println("Calle: " + calle.nombre + " " + calle.altura);
        System.out.println("Tramo: " + calle.origen.nombre + " -> " + calle.destino.nombre);
        System.out.println("Vehículos circulando: " + cantidadVehiculos);

        if (demoraAccidente >= 999999) {
            System.out.println("Estado: bloqueada por accidente grave");
        } else if (demoraAccidente > 0) {
            System.out.println("Demora por accidente: " + demoraAccidente + " minutos");
        } else {
            System.out.println("Demora por accidente: sin demora");
        }

        System.out.println("Puntaje de criticidad: " + puntajeCriticidad);
        System.out.println("-----------------------------");
    }
}
