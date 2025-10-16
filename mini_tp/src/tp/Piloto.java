package tp;

public class Piloto {

	private String nombre;
	private String escuderia;
	private double tiempoVuelta;
	
	public Piloto(String nombre, String escuderia, double tiempoVuelta) {
		this.nombre = nombre;
		this.escuderia = escuderia;
		this.tiempoVuelta = tiempoVuelta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	public double getTiempoVuelta() {
		return tiempoVuelta;
	}

	public void setTiempoVuelta(double tiempoVuelta) {
		this.tiempoVuelta = tiempoVuelta;
	}
}
