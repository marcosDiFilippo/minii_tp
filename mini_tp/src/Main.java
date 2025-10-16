import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		ArrayList<Escuderia> equipos = new ArrayList<Escuderia>();

		equipos.add(new Escuderia ("Ferrari"));
		equipos.add(new Escuderia ("Williams"));
		equipos.add(new Escuderia ("Mercedes"));
		equipos.add(new Escuderia ("Alpine"));

		for (int i = 0; i < equipos.size(); i++) {
			int sumaTotal = 0;
			equipos.get(i).asignarPuntosRonda();
			equipos.get(i).sumarTotal();
			JOptionPane.showMessageDialog(null, "Nombre de equipo: " + equipos.get(i).getNombre() + "\n             Puntos x ronda: " + equipos.get(i).getPuntosPorRonda());
			JOptionPane.showMessageDialog(null,"Nombre de equipo: " + equipos.get(i).getNombre() + " | Total de puntos por ronda: " + equipos.get(i).getSumaTotalPuntos());
		}

		Carrera formula1 = new Carrera("Formula 1", equipos);

		ArrayList<Piloto> pilotos = new ArrayList<>();

        pilotos.add(new Piloto("Marco Rossi", equipos.get(0), 78.432));
        pilotos.add(new Piloto("Liam Becker", equipos.get(2), 77.912));
        pilotos.add(new Piloto("Ethan Nakamura", equipos.get(2), 77.654));
        pilotos.add(new Piloto("Santiago López", equipos.get(1), 78.221));
        pilotos.add(new Piloto("Lucas Bianchi", equipos.get(1), 78.903));
        pilotos.add(new Piloto("Noah Smith", equipos.get(1), 79.412));
        pilotos.add(new Piloto("Mateo Fernández", equipos.get(3), 78.765));
        pilotos.add(new Piloto("Oliver Müller", equipos.get(3), 79.654));

        Piloto mejorPiloto = pilotos.stream()
                .max((p1, p2) -> Double.compare(p1.getTiempoVuelta(), p2.getTiempoVuelta()))
                .orElse(null);

        if (mejorPiloto != null) {
                JOptionPane.showMessageDialog(null,
                "Mejor tiempo: " + mejorPiloto.getTiempoVuelta() +
                "\nPiloto: " + mejorPiloto.getNombre() +
                "\nEscudería: " + mejorPiloto.getEscuderia().getNombre());
        }
        
        Piloto peorPiloto = pilotos.stream()
                .min((p1, p2) -> Double.compare(p1.getTiempoVuelta(), p2.getTiempoVuelta()))
                .orElse(null);

        if (peorPiloto != null) {
            JOptionPane.showMessageDialog(null,
                "Menor tiempo: " + peorPiloto.getTiempoVuelta() +
                "\nPiloto: " + peorPiloto.getNombre() +
                "\nEscudería: " + peorPiloto.getEscuderia().getNombre());
        }
        
        double promedioTiempo = pilotos.stream()
                .mapToDouble(Piloto::getTiempoVuelta)
                .average()
                .orElse(0);

        JOptionPane.showMessageDialog(null, "Promedio de tiempos: " + promedioTiempo);
        	    
        	    LinkedList<Piloto> tiempoMenorAMayor = pilotos.stream()
        	    		.sorted(Comparator.comparing(Piloto::getTiempoVuelta).reversed())
        	    		.collect(Collectors.toCollection(LinkedList::new));

				String message = "\n------TOP 3 MEJORES TIEMPOS------\n";

				for (int i = 0; i < 3; i++) {
					message += "Piloto: " + tiempoMenorAMayor.get(i).getNombre() + " | Escuderia: " + tiempoMenorAMayor.get(i).getEscuderia().getNombre() + " | Tiempo: " + tiempoMenorAMayor.get(i).getTiempoVuelta() + "\n";
				}

				JOptionPane.showMessageDialog(null, message);

        	    StringBuilder mensaje = new StringBuilder("Pilotos ordenados por tiempo:\n");
        	    for (Piloto p : tiempoMenorAMayor) {
        	        mensaje.append(p.getNombre())
        	               .append(" - ")
        	               .append(p.getEscuderia().getNombre())
        	               .append(" - ")
        	               .append(p.getTiempoVuelta())
        	               .append(" seg\n");
        	    }

        	    JOptionPane.showMessageDialog(null, mensaje.toString());

        	    String[] escuderias = {"Ferrari", "Mercedes", "Williams", "Alpine"};

        	    StringBuilder mensajeEscuderia = new StringBuilder("Cantidad de pilotos por escudería:\n");

        	    for (String e : escuderias) {
        	    	int cantidad = (int) pilotos.stream()
        	                .filter(p -> p.getEscuderia().getNombre().equals(e))
        	                .count();

        	    	mensajeEscuderia.append(e).append(": ").append(cantidad).append(" pilotos\n");
        	    }

        	    JOptionPane.showMessageDialog(null, mensajeEscuderia.toString());
	}
}
