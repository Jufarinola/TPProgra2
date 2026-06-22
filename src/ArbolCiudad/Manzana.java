package ArbolCiudad;

import GrafoVial.Interseccion;
import Interfaces.IManzana;

public class Manzana implements IManzana {
    String nombre;

    Interseccion esquina1;
    Interseccion esquina2;
    Interseccion esquina3;
    Interseccion esquina4;

    public Manzana(String nombre,
                   Interseccion esquina1,
                   Interseccion esquina2,
                   Interseccion esquina3,
                   Interseccion esquina4) {

        this.nombre = nombre;
        this.esquina1 = esquina1;
        this.esquina2 = esquina2;
        this.esquina3 = esquina3;
        this.esquina4 = esquina4;
    }

    @Override
    public void mostrarManzana() {

        System.out.println("Manzana: " + nombre);

        System.out.println("Esquina 1: " + esquina1.nombre);
        System.out.println("Esquina 2: " + esquina2.nombre);
        System.out.println("Esquina 3: " + esquina3.nombre);
        System.out.println("Esquina 4: " + esquina4.nombre);
    }
}

