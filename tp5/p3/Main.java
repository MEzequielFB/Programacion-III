import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> actividades = new ArrayList<>();
        actividades.add("actividad1");
        actividades.add("actividad2");
        actividades.add("actividad3");
        actividades.add("actividad4");
        actividades.add("actividad5");
        actividades.add("actividad6");

        ArrayList<Integer> tiempos_comienzo = new ArrayList<>();
        tiempos_comienzo.add(9);
        tiempos_comienzo.add(13);
        tiempos_comienzo.add(11);
        tiempos_comienzo.add(15);
        tiempos_comienzo.add(15);
        tiempos_comienzo.add(16);

        ArrayList<Integer> tiempos_fin = new ArrayList<>();
        tiempos_fin.add(10);
        tiempos_fin.add(15);
        tiempos_fin.add(15);
        tiempos_fin.add(16);
        tiempos_fin.add(18);
        tiempos_fin.add(17);

        GreedyActividades greedy = new GreedyActividades(actividades, tiempos_comienzo, tiempos_fin);
        System.out.println("Solucion: " + greedy.greedy());
    }
}