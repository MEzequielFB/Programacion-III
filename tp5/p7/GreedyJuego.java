import java.util.ArrayList;
import java.util.List;

public class GreedyJuego {
    private static int _cazador;
    private static int _leon;

    private List<Integer> leones_cazados;

    public GreedyJuego() {
        _cazador = 0;
        _leon = 1;

        this.leones_cazados = new ArrayList<>();
    }

    public List<Integer> greedy(List<Integer> personajes, int limite_pasos) {
        while (!personajes.isEmpty() && this.hayCazadores(personajes) && this.hayLeones(personajes)) {
            int posicion_cazador = this.seleccionar(personajes, limite_pasos);
        }

        return this.leones_cazados;
    }

    //VER COMO BORRAR EL LEON SIN AFECTAR LA POSICION DEL CAZADOR
    private int seleccionar(List<Integer> personajes, int limite_pasos) {
        int posicion_mejor_candidato = -1;
        int posicion = 0;
        int pasos_leon_cercano = -1;

        for (int personaje : personajes) {
            if (personaje == _cazador) {
                int pasos_leon_cercano_actual = this.getPasosLeonCercano(personajes, posicion, limite_pasos);
                if (pasos_leon_cercano == -1 || ( pasos_leon_cercano_actual != -1 && pasos_leon_cercano_actual < pasos_leon_cercano ) ) {
                    posicion_mejor_candidato = posicion;
                    pasos_leon_cercano = pasos_leon_cercano_actual;
                }
            }

            posicion++;
        }
        return posicion_mejor_candidato;
    }

    private int getPasosLeonCercano(List<Integer> personajes, int posicion_cazador, int limite_pasos) {
        int pasos = -1;
        for (int i = posicion_cazador; i >= 0; i--) {
            if (personajes.get(i) == _leon) {
                int pasos_actual = posicion_cazador - i;
                if (pasos == -1 || ( pasos_actual < pasos && pasos_actual < limite_pasos)) {
                    pasos = pasos_actual;
                }
            }
        }

        for (int i = posicion_cazador; i < personajes.size(); i++) {
            if (personajes.get(i) == _leon) {
                int pasos_actual = i - posicion_cazador;
                if (pasos == -1 || ( pasos_actual < pasos && pasos_actual < limite_pasos)) {
                    pasos = pasos_actual;
                }
            }
        }
        return pasos;
    }

    private boolean hayCazadores(List<Integer> personajes) {
        return personajes.contains(_cazador);
    }

    private boolean hayLeones(List<Integer> personajes) {
        return personajes.contains(_leon);
    }
}
