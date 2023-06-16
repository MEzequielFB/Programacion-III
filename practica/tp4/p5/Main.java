import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Tarea tarea1 = new Tarea("tarea1", 2);
        Tarea tarea2 = new Tarea("tarea2", 3);
        Tarea tarea3 = new Tarea("tarea3", 2);
        Tarea tarea4 = new Tarea("tarea4", 4);
        Tarea tarea5 = new Tarea("tarea5", 5);
        Tarea tarea6 = new Tarea("tarea6", 3);
        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tarea5);
        tareas.add(tarea1);
        tareas.add(tarea2);
        tareas.add(tarea6);
        tareas.add(tarea3);
        tareas.add(tarea4);

        Procesador procesador1 = new Procesador();
        Procesador procesador2 = new Procesador();
        Procesador procesador3 = new Procesador();
        ArrayList<Procesador> procesadores = new ArrayList<>();
        procesadores.add(procesador1);
        procesadores.add(procesador2);
        procesadores.add(procesador3);

        Backtracking back = new Backtracking();
        System.out.println("Solucion: " + back.getMejorAsignacion(procesadores, tareas));
    }
}