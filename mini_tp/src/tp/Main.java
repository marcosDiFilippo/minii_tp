package tp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Piloto> pilotos = new ArrayList<>();

        pilotos.add(new Piloto("Marco Rossi", "Ferrari", 78.432));
        pilotos.add(new Piloto("Liam Becker", "Mercedes", 77.912));
        pilotos.add(new Piloto("Ethan Nakamura", "Mercedes", 77.654));
        pilotos.add(new Piloto("Santiago López", "Williams", 78.221));
        pilotos.add(new Piloto("Lucas Bianchi", "Williams", 78.903));
        pilotos.add(new Piloto("Noah Smith", "Williams", 79.412));
        pilotos.add(new Piloto("Mateo Fernández", "Alpine", 78.765));
        pilotos.add(new Piloto("Oliver Müller", "Alpine", 79.654));

        Piloto mejorPiloto = pilotos.stream()
                .max((p1, p2) -> Double.compare(p1.getTiempoVuelta(), p2.getTiempoVuelta()))
                .orElse(null);

        if (mejorPiloto != null) {
            JOptionPane.showMessageDialog(null,
                "Mejor tiempo: " + mejorPiloto.getTiempoVuelta() +
                "\nPiloto: " + mejorPiloto.getNombre() +
                "\nEscudería: " + mejorPiloto.getEscuderia());
        }
        
        Piloto peorPiloto = pilotos.stream()
                .min((p1, p2) -> Double.compare(p1.getTiempoVuelta(), p2.getTiempoVuelta()))
                .orElse(null);

        if (peorPiloto != null) {
            JOptionPane.showMessageDialog(null,
                "Menor tiempo: " + peorPiloto.getTiempoVuelta() +
                "\nPiloto: " + peorPiloto.getNombre() +
                "\nEscudería: " + peorPiloto.getEscuderia());
        }
        
        double promedioTiempo = pilotos.stream()
                .mapToDouble(Piloto::getTiempoVuelta)
                .average()
                .orElse(0);

        JOptionPane.showMessageDialog(null, "Promedio de tiempos: " + promedioTiempo);
        	    
        	    LinkedList<Piloto> tiempoMenorAMayor = pilotos.stream()
        	    		.sorted(Comparator.comparing(Piloto::getTiempoVuelta))
        	    		.collect(Collectors.toCollection(LinkedList::new));
        	    
        	    StringBuilder mensaje = new StringBuilder("Pilotos ordenados por tiempo:\n");
        	    for (Piloto p : tiempoMenorAMayor) {
        	        mensaje.append(p.getNombre())
        	               .append(" - ")
        	               .append(p.getEscuderia())
        	               .append(" - ")
        	               .append(p.getTiempoVuelta())
        	               .append(" seg\n");
        	    }

        	    JOptionPane.showMessageDialog(null, mensaje.toString());

        	    String[] escuderias = {"Ferrari", "Mercedes", "Williams", "Alpine"};

        	    StringBuilder mensajeEscuderia = new StringBuilder("Cantidad de pilotos por escudería:\n");

        	    for (String e : escuderias) {
        	    	int cantidad = (int) pilotos.stream()
        	                .filter(p -> p.getEscuderia().equals(e))
        	                .count();

        	    	mensajeEscuderia.append(e).append(": ").append(cantidad).append(" pilotos\n");
        	    }

        	    JOptionPane.showMessageDialog(null, mensajeEscuderia.toString());

	}
}
