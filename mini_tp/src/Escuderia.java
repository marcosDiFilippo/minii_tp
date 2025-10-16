import java.util.ArrayList;

public class Escuderia {

    private String nombre;
    private ArrayList<Integer> puntosPorRonda;
    private int sumaTotalPuntos;

    public Escuderia(String nombre) {
        super();
        this.nombre = nombre;
        this.sumaTotalPuntos = 0;
        this.puntosPorRonda = new ArrayList<Integer>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getSumaTotalPuntos() {
        return sumaTotalPuntos;
    }

    public void setSumaTotalPuntos(int sumaTotalPuntos) {
        this.sumaTotalPuntos = sumaTotalPuntos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getPuntosPorRonda() {
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
        for (int i = 0; i < 3; i++) {
            this.puntosPorRonda.add(((int) (Math.random() * 15 + 10)));
        }
    }
    public int sumarTotal () {
        this.sumaTotalPuntos = puntosPorRonda.stream()
                .mapToInt(Integer::intValue)
                .sum();

        return sumaTotalPuntos;
    }
}