package reportes;

import java.time.LocalDateTime;

public class EventosSistema {
    public String tipo;
    public String descripcion;
    public Object objeto;
    public LocalDateTime fechaHora;

    public EventosSistema(String tipo, String descripcion, Object objeto) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.objeto = objeto;
        this.fechaHora = LocalDateTime.now();
    }

    public void mostrarEvento() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Fecha: " + fechaHora);
        System.out.println("----------------------");
    }
}
