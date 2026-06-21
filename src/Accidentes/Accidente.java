package Accidentes;

import java.time.LocalDateTime;

public class Accidente {
    public LocalDateTime fechahora;
    public String gravedad;

    public Accidente(String gravedad){
    this.fechahora = LocalDateTime.now();
    this.gravedad = gravedad; // Leve, Moderado, Grave
    }
}