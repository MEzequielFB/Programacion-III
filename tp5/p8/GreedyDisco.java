import java.util.ArrayList;
import java.util.List;

//M es la capacidad del disco
public class GreedyDisco {
    private List<ArchivoCancion> solucion;
    private double m;
    private int cantidad_limite_generos_repetidos;

    public GreedyDisco(double m, int cantidad_limite_generos_repetidos) {
        this.solucion = new ArrayList<>();
        this.m = m;
        this.cantidad_limite_generos_repetidos = cantidad_limite_generos_repetidos;
    }

    //Devuelve una solucion (las canciones que contenera el disco)
    public List<ArchivoCancion> greedy(List<ArchivoCancion> canciones) {
        List<ArchivoCancion> canciones_seleccionadas = new ArrayList<>();

        //Mientras el tamanio de las canciones seleccionadas sea menor al de las canciones y el espacion disponible del disco sea mayor a 0...
        while (canciones_seleccionadas.size() < canciones.size() && this.obtenerEspacioDisponible() > 0) {

            //Selecciona un candidato, lo agrega a los seleccionados y verifica que sea factible agregarlo a la solucion
            ArchivoCancion candidato = this.seleccionar(canciones, canciones_seleccionadas);
            canciones_seleccionadas.add(candidato);

            if (this.esFactible(candidato)) {
                this.solucion.add(candidato);
            }
        }

        return new ArrayList<>(this.solucion);
    }

    //El candidato es factible cuando su tamanio es menor a la capacidad disponible del disco y su genero respeta el limite de generos repetidos
    private boolean esFactible(ArchivoCancion candidato) {
        return candidato.getTamanio() < this.obtenerEspacioDisponible() && this.obtenerCantidadGeneroEnSolucion(candidato.getGenero()) < this.cantidad_limite_generos_repetidos;
    }

    //Selecciona a los candidatos de mayor tamanio
    protected ArchivoCancion seleccionar(List<ArchivoCancion> canciones, List<ArchivoCancion> canciones_seleccionadas) {
        ArchivoCancion mejor_candidato = null;
        for (ArchivoCancion cancion : canciones) {
            if (mejor_candidato == null || cancion.getTamanio() > mejor_candidato.getTamanio()) {
                if (!canciones_seleccionadas.contains(cancion)) {
                    mejor_candidato = cancion;
                }
            }
        }
        return mejor_candidato;
    }

    private double obtenerEspacioDisponible() {
        return this.m - this.obtenerTamanioSolucion();
    }

    //Devuelve la sumatoria de los tamanios de las canciones contenidas en la solucion
    private double obtenerTamanioSolucion() {
        double tamanio_total = 0;
        for (ArchivoCancion cancion : this.solucion) {
            tamanio_total += cancion.getTamanio();
        }
        return tamanio_total;
    }

    //Devuelve la cantidad de canciones de un determinado genero en la solucion
    private int obtenerCantidadGeneroEnSolucion(String genero) {
        int cantidad = 0;
        for (ArchivoCancion cancion : this.solucion) {
            if (cancion.getGenero().equalsIgnoreCase(genero)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public double getM() {
        return this.m;
    }
}