import java.util.ArrayList;
import java.util.List;

public class GreedyDisco {
    private List<ArchivoCancion> solucion;
    private double m;
    private int cantidad_limite_generos_repetidos;

    public GreedyDisco(double m, int cantidad_limite_generos_repetidos) {
        this.solucion = new ArrayList<>();
        this.m = m;
        this.cantidad_limite_generos_repetidos = cantidad_limite_generos_repetidos;
    }

    public List<ArchivoCancion> greedy(List<ArchivoCancion> canciones) {
        List<ArchivoCancion> canciones_seleccionadas = new ArrayList<>();

        while (canciones_seleccionadas.size() < canciones.size() && this.obtenerEspacioDisponible() > 0) {
            ArchivoCancion candidato = this.seleccionar(canciones, canciones_seleccionadas);
            canciones_seleccionadas.add(candidato);

            if (this.esFactible(candidato)) {
                this.solucion.add(candidato);
            }
        }

        return new ArrayList<>(this.solucion);
    }

    private boolean esFactible(ArchivoCancion candidato) {
        return candidato.getTamanio() < this.obtenerEspacioDisponible() && this.obtenerCantidadGeneroEnSolucion(candidato.getGenero()) < this.cantidad_limite_generos_repetidos;
    }

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

    private double obtenerTamanioSolucion() {
        double tamanio_total = 0;
        for (ArchivoCancion cancion : this.solucion) {
            tamanio_total += cancion.getTamanio();
        }
        return tamanio_total;
    }

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