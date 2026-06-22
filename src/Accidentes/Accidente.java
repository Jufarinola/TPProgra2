package Accidentes;

import Interfaces.IAccidente;
import java.time.LocalDateTime;

public class Accidente implements IAccidente {
    public LocalDateTime fechahora;
    public String gravedad;

    public Accidente(String gravedad){
        this.fechahora = LocalDateTime.now();
        this.gravedad = gravedad;
    }

    public void mostrarAccidente(){
        System.out.println("Accidente " + gravedad + " registrado el: " + fechahora);
    }
}