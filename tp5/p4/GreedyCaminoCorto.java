import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GreedyCaminoCorto {
    private static int _infinito;

    private List<Integer> solucion;
    private List<Integer> distancias;
    private List<Integer> padres;

    public GreedyCaminoCorto() {
        _infinito = 999999999;

        this.solucion = new ArrayList<>();
        this.distancias = new ArrayList<>();
        this.padres = new ArrayList<>();
    }

    public List<List<Integer>> greedy(Grafo<Integer> grafo, int origen) {
        //Si el grafo no contiene el origen pasado no realiza el greedy
        if (grafo.contieneVertice(origen)) {

            //Agrega infinitos a la lista distancias y nulos a la lista padres 
            for (int i = 0; i < grafo.cantidadVertices(); i++) {
                this.distancias.add(_infinito);
                this.padres.add(null);
            }

            //Setea la distancia del origen como 0
            int posicion_vertice = grafo.obtenerPosicionVertice(origen);
            this.distancias.set(posicion_vertice, 0);

            //Mientras el tamanio de la solucion sea menor a la cantidad de vertices...
            while (this.solucion.size() < grafo.cantidadVertices()) {

                //Selecciona al mejor candidato y lo agrega a la solucion
                int posicion_candidato = this.seleccionar(grafo);
                int candidato = grafo.obtenerVertice(posicion_candidato);
                this.solucion.add(candidato);

                //Obtiene los adyacentes del candidato
                Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(candidato);
                while (adyacentes.hasNext()) {
                    int adyacente = adyacentes.next();
                    int posicion_adyacente = grafo.obtenerPosicionVertice(adyacente);

                    int distancia_entre_vertices = grafo.obtenerArco(candidato, adyacente).getEtiqueta();

                    //Si la suma entre la distancia del candidato y la distancia entre el candidato y su adyacente es menor a la distancia del adyacente
                    //Setea la suma a entre la distancia del candidato y la distancia entre el candidato y su adyacente como la distancia del adyacente
                    //Setea al candidato como padre de su adyacente
                    if (this.distancias.get(posicion_candidato) + distancia_entre_vertices < this.distancias.get(posicion_adyacente)) {
                        this.distancias.set(posicion_adyacente, this.distancias.get(posicion_candidato) + distancia_entre_vertices);
                        this.padres.set(posicion_adyacente, candidato);
                    }
                }
            }
        }

        //Devuelve una lista de listas que contiene las distancias entre el origen y los demas vertices
        //Y los padres de cada uno los vertices
        List<List<Integer>> solucion_final = new ArrayList<>();
        solucion_final.add(new ArrayList<>(this.distancias));
        solucion_final.add(new ArrayList<>(this.padres));

        return solucion_final;
    }

    //Selecciona al candidato con menor distancia y que no haya sido agregado a la solucion aun
    private Integer seleccionar(Grafo<Integer> grafo) {
        int posicion_mejor_candidato = -1;
        for (int i = 0; i < this.distancias.size(); i++) {
            if (( posicion_mejor_candidato == -1 || this.distancias.get(i) < this.distancias.get(posicion_mejor_candidato) ) && !this.solucion.contains(grafo.obtenerVertice(i))) {
                posicion_mejor_candidato = i;
            }
        }
        return posicion_mejor_candidato;
    }
}