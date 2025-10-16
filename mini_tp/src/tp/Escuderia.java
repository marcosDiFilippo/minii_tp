import java.util.ArrayList;
import java.util.List;

public class Escuderia {

    private String nombre;
    public ArrayList<Integer> puntosPorRonda;

    public Escuderia(String nombre) {
        super();
        this.nombre = nombre;
        this.puntosPorRonda = new ArrayList<Integer>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getPuntosPorRonda() {
        return puntosPorRonda;
    }

    public void setPuntosPorRonda(ArrayList<Integer> puntosPorRonda) {
        this.puntosPorRonda = puntosPorRonda;
    }

    @Override
    public String toString() {
        return "Escuderia [nombre=" + nombre + ", puntosPorRonda=" + puntosPorRonda + "]";
    }

    public void asignarPuntosRonda() {
        int minimo = 10;
        int maximo = 25;

        for (int i = 0; i < 3; i++) {
            this.puntosPorRonda.add(((int)(Math.random()* 15 + 10 )));
        }
    }

}