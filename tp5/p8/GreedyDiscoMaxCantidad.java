import java.util.List;

public class GreedyDiscoMaxCantidad extends GreedyDisco {

    public GreedyDiscoMaxCantidad(double m, int cantidad_limite_generos_repetidos) {
        super(m, cantidad_limite_generos_repetidos);
    }

    @Override
    protected ArchivoCancion seleccionar(List<ArchivoCancion> canciones, List<ArchivoCancion> canciones_seleccionadas) {
        ArchivoCancion mejor_candidato = null;
        for (ArchivoCancion cancion : canciones) {
            if (mejor_candidato == null || cancion.getTamanio() < mejor_candidato.getTamanio()) {
                if (!canciones_seleccionadas.contains(cancion)) {
                    mejor_candidato = cancion;
                }
            }
        }
        return mejor_candidato;
    }
}