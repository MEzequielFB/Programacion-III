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

            if (posicion_cazador != -1) {
                personajes.remove(posicion_cazador);
                this.leones_cazados.add(_leon);
            }
        }

        return this.leones_cazados;
    }

    //Selecciona la posicion del cazador mas cercano a un leon y elimina al leon de la lista de personajes
    private int seleccionar(List<Integer> personajes, int limite_pasos) {
        int posicion_mejor_candidato = -1;
        int posicion = 0;
        int pasos_leon_cercano = -1;

        for (int personaje : personajes) {
            if (personaje == _cazador) {
                int pasos_leon_cercano_actual = this.getPasosLeonCercano(personajes, posicion, limite_pasos);
                if (pasos_leon_cercano_actual < limite_pasos && pasos_leon_cercano_actual != -1 && ( pasos_leon_cercano_actual < pasos_leon_cercano || pasos_leon_cercano == -1) ) {
                    posicion_mejor_candidato = posicion;
                    pasos_leon_cercano = pasos_leon_cercano_actual;
                }
            }

            posicion++;
        }

        if (posicion_mejor_candidato != -1 && pasos_leon_cercano != -1) {
            int posicion_borrada = this.borrarLeonCercano(personajes, posicion_mejor_candidato, pasos_leon_cercano);
            if (posicion_borrada != -1 && posicion_borrada < posicion_mejor_candidato) {
                posicion_mejor_candidato--;
            }
        }
        return posicion_mejor_candidato;
    }

    //Elimina al leon mas cercano a la posicion de un cazador
    private int borrarLeonCercano(List<Integer> personajes, int posicion_cazador, int cantidad_pasos) {
        int posicion_leon = -1;

        for (int i = posicion_cazador; i >= 0; i--) {
            if (personajes.get(i) == _leon) {
                int pasos_actual = posicion_cazador - i;
                if (pasos_actual == cantidad_pasos) {
                    posicion_leon = i;
                }
            }
        }

        if (posicion_leon == -1) {
            for (int i = posicion_cazador; i < personajes.size(); i++) {
                if (personajes.get(i) == _leon) {
                    int pasos_actual = i - posicion_cazador;
                    if (pasos_actual == cantidad_pasos) {
                        posicion_leon = i;
                    }
                }
            }
        }
        personajes.remove(posicion_leon);
        return posicion_leon;
    }

    //Devuelve la cantidad de pasos a la que esta el leon mas cercano a un cazador
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
