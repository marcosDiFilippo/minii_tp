import java.util.ArrayList;

public class Carrera {

    private String nombre;
    public ArrayList<Escuderia> equipo = new ArrayList<Escuderia>();

    public Carrera(String nombre, ArrayList<Escuderia> equipo) {
        super();
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Escuderia> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<Escuderia> equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Carrera [nombre=" + nombre + ", equipo=" + equipo + "]";
    }
}