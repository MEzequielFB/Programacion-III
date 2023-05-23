import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioCaminos<T> {
    private Grafo<?> grafo;
    private String origen;
    private String destino;
    private Arco<T> camino_cortado;

    public ServicioCaminos(Grafo<?> grafo, String origen, String destino, Arco<T> camino_cortado) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.camino_cortado = camino_cortado;
    }

    public List<List<String>> caminos() {
        List<List<String>> caminos = new LinkedList<>();
        if (this.grafo.contieneVertice(this.origen) && this.grafo.contieneVertice(this.destino)) {
            this.obtenerCaminos(caminos);
        }
        return caminos;
    }

    private void obtenerCaminos(List<List<String>> caminos) {
        LinkedList<String> ciudades_visitadas = new LinkedList<>();
        LinkedList<Arco<String>> rutas_pasadas = new LinkedList<>();

        ciudades_visitadas.add(this.origen);
        Iterator<String> adyacentes = this.grafo.obtenerAdyacentes(this.origen);
        while (adyacentes.hasNext()) {
            String adyacente = adyacentes.next();

            Arco<String> ruta_actual = new Arco<>(this.origen, adyacente, "");
            if (!this.estaCortada(ruta_actual)) {
                rutas_pasadas.add(ruta_actual);
                this.agregarCaminos(adyacente, caminos, ciudades_visitadas, rutas_pasadas);
                ciudades_visitadas.removeLast();
                rutas_pasadas.removeLast();
            }
        }
    }

    private void agregarCaminos(String vertice, List<List<String>> caminos, LinkedList<String> ciudades_visitadas, LinkedList<Arco<String>> rutas_pasadas) {
        ciudades_visitadas.add(vertice);
        if (vertice.equals(this.destino)) {
            caminos.add(new LinkedList<>(ciudades_visitadas));
            return;
        }

        Iterator<String> adyacentes = this.grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            String adyacente = adyacentes.next();

            Arco<String> ruta_actual = new Arco<>(vertice, adyacente, "");
            if (!this.contieneRuta(ruta_actual, rutas_pasadas) && !this.estaCortada(ruta_actual)) {
                rutas_pasadas.add(ruta_actual);
                this.agregarCaminos(adyacente, caminos, ciudades_visitadas, rutas_pasadas);
                rutas_pasadas.removeLast();
                ciudades_visitadas.removeLast();
            }
        }
    }

    private boolean estaCortada(Arco<String> ruta) {
        return ruta.equals(this.camino_cortado) || ( ruta.getVerticeOrigen().equals(this.camino_cortado.getVerticeDestino()) && ruta.getVerticeDestino().equals(this.camino_cortado.getVerticeOrigen()) );
    }

    //EN LUGAR DE ESTO PODRIA PREGUNTAR POR LOS VERTICES PASADOS
    private boolean contieneRuta(Arco<String> ruta, LinkedList<Arco<String>> rutas_pasadas) {
        String ruta_origen = ruta.getVerticeOrigen();
        String ruta_destino = ruta.getVerticeDestino();
        for (Arco<String> ruta_pasada : rutas_pasadas) {
            String ruta_pasada_origen = ruta_pasada.getVerticeOrigen();
            String ruta_pasada_destino = ruta_pasada.getVerticeDestino();

            if (( ruta_origen.equals(ruta_pasada_origen) && ruta_destino.equals(ruta_pasada_destino) ) || ( ruta_origen.equals(ruta_pasada_destino) && ruta_destino.equals(ruta_pasada_origen) )) {
                return true;
            }
        }
        return false;
    }
}